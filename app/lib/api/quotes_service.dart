import 'package:app/models/quotesList.dart';
import 'package:http/http.dart' as http;
import 'dart:convert' as convert;

class QoutesService{
  Future<QuotesList> fetchQuotes () async{
    final response = await
    http.get(Uri.parse('http://localhost:5000/quotes/'));
    if(response.statusCode == 200){
      return QuotesList.fromJson(convert.jsonDecode(response.body));
    }else{
      throw Exception('Failed to load quotes');
    }
  }
}

