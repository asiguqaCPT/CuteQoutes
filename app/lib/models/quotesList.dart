import 'package:app/models/quote.dart';

class QuotesList{
  final List<Quote> quotes;

  QuotesList({required this.quotes});

  factory QuotesList.fromJson(List<dynamic> parsedJson){
    var quoteList = parsedJson.map((i)=>Quote.fromJson(i)).toList();
    return QuotesList(quotes: quoteList);
  }
}