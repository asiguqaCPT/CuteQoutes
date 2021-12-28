package api;

import dataAccess.*;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import io.javalin.http.NotFoundResponse;
import net.lemnik.eodsql.QueryTool;

import java.sql.Connection;

public class QuoteApiHandler {
    static DBConnect dbConnect = new DBConnect("quotes.db");
    static Connection connection = dbConnect.getConnection();
    static final QuotesDAI dai = QueryTool.getQuery( connection, QuotesDAI.class );

    /**
     * Get all quotes
     *
     * @param context The Javalin Context for the HTTP GET Request
     */
    public static void getAll(Context context) {
         context.json(dai.getAllQuotes());
    }

    /**
     * Get one quote
     *
     * @param context The Javalin Context for the HTTP GET Request
     */
    public static void getOne(Context context) {
        Integer id = context.pathParamAsClass("id", Integer.class).get();
        QuotesDO quotesDO = dai.getQuote(id);

        if (quotesDO == null) {
            throw new NotFoundResponse("cuteQuotes.Quote not found: " + id);
        }
        context.json(quotesDO);
    }
    /**
     * Create a new quote
     *
     * @param context The Javalin Context for the HTTP POST Request
     */
    public static void create(Context context) {
        QuotesDO quotesDO = context.bodyAsClass(QuotesDO.class);
        dai.addQuote(quotesDO);
        int quoteID = dai.getQuoteId(quotesDO.getName());
        context.header("Location", "/quote/" + quoteID);
        context.status(HttpCode.CREATED);
        context.json(dai.getQuote(quoteID));
    }
}