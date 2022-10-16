function doPost(e) {
  var replyToken= JSON.parse(e.postData.contents).events[0].replyToken;
  if (typeof replyToken === 'undefined') {
    return;
  }

  var message = 'メッセージは文章で送ってください。';
  var url = 'https://api.line.me/v2/bot/message/reply';
  var channelToken = '【チャネルアクセストークン】';
  
  var input = JSON.parse(e.postData.contents).events[0].message;
  
  if(input.type == 'text') {
    message = LanguageApp.translate(input.text, 'ja', 'en');
  }

  var messages = [{
    'type': 'text',
    'text': message,
  }];

  UrlFetchApp.fetch(url, {
    'headers': {
      'Content-Type': 'application/json; charset=UTF-8',
      'Authorization': 'Bearer ' + channelToken,
    },
    'method': 'post',
    'payload': JSON.stringify({
      'replyToken': replyToken,
      'messages': messages,
    }),
  });
  return ContentService.createTextOutput(JSON.stringify({'content': 'post ok'})).setMimeType(ContentService.MimeType.JSON);
}