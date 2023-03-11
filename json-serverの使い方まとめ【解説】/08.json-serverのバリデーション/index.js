const jsonServer = require('json-server');
const server = jsonServer.create();
const middlewares = jsonServer.defaults();

server.use(middlewares);
server.use(jsonServer.bodyParser);

const validateRequest = (req, res, next) => {
  if (req.method === 'POST' && !req.body.name) {
    return res.status(400).json({ error: 'name is required' });
  }
  if (req.method === 'PUT' && !req.body.id) {
    return res.status(400).json({ error: 'id is required' });
  }
  next();
};

server.use(validateRequest);

server.get('*', (req, res) => {
    res.status(200).json(req.query);
  });
  
  server.post('*', (req, res) => {
    res.status(201).json(req.body);
  });
  
  server.put('*', (req, res) => {
    res.status(200).json(req.body);
  });
  
  server.delete('*', (req, res) => {
    res.status(204).end();
  });

server.listen(8000, () => {
  console.log('JSON Server is running');
});