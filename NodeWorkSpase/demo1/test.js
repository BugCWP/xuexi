var http=require('http');
http.createServer(function (req,res) {
    res.writeHead(200,{'Context-Type':'text/html'});
    res.write('<h1>helloworld</h1>');
    res.end('<p>Hello f</p>');
}).listen(3000);
console.log('open 2s');