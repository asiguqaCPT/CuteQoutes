class Quote {
  final int _id;
  final String _name;
  final String _text;

  Quote({required id, required name, required text})
      : _id = id,
        _name = name,
        _text = text;

  factory Quote.fromJson(Map<String, dynamic> json){
    return Quote(id: json['id'], name: json['name'], text: json['text']);
  }
  get name {
    return _name;
  }

  get text {
    return _text;
  }

  get id {
    return _id;
  }
}
