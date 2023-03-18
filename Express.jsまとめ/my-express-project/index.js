const serverlessExpress = require('@vendia/serverless-express');
const express = require('express');
const app = express();

const loggerMiddleware = function (req, res, next) {
    console.log(`[${new Date()}] ${req.method} ${req.url}`);
    next();
};

app.use(loggerMiddleware);

// GETリクエスト
app.get('/', (req, res) => {
    res.send({
        msg: 'GET request'
    });
});

// POSTリクエスト
app.post('/', (req, res) => {
    res.send({
        msg: 'POST request'
    });
});

// PUTリクエスト
app.put('/:id', (req, res) => {
    res.send({
        id: req.params.id,
        msg: 'PUT request'
    });
});

// DELETEリクエスト
app.delete('/:id', (req, res) => {
    res.send({
        id: req.params.id,
        msg: 'DELETE request'
    });
});

if (process.env.EXPRESS_ENV === 'production') {
    // 本番環境
    exports.handler = serverlessExpress({ app });
}else{
    // ローカル環境
    app.listen(3000, () => {
        console.log('Server started on port 3000');
    });
}
