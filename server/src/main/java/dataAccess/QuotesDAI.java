package dataAccess;
import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.List;

public interface QuotesDAI extends BaseQuery{
    @Select(
            "SELECT * FROM QUOTES q"
            + " WHERE q.id = ?{1}"
    )
    QuotesDO getQuote(int quoteId);

    @Select(
            "SELECT id FROM QUOTES q"
                    + " WHERE q.name = ?{1}"
    )
    int getQuoteId(String name);

    @Select(
            "SELECT * FROM QUOTES"
    )
    List<QuotesDO> getAllQuotes();

    @Update(
            "INSERT INTO quotes (text, name) "
                    +" VALUES ( ?{1.text}, ?{1.name})"
    )
    void addQuote(QuotesDO quote);
}
