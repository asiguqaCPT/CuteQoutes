import 'package:flutter/material.dart';
import 'screens/quotes_screen.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Inspirational quotes"),
        centerTitle: true,
      ),
      body: const QuotesScreen(),
    );
  }
}
