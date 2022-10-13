const http = require('http');

const port = process.env.PORT;

const requestListener = function (req, res) {
  res.writeHead(200);
  res.end('Green Enterprise Apps with Node.');
}

const server = http.createServer(requestListener);
server.listen(port !== "" ? port : "8080");
