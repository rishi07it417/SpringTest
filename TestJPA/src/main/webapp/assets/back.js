const http = require('http');

const hostname = '127.0.0.1';
const PORT = 9999;

var DATA = [
    {
        "processName": "ARCHWELL_APPRAISAL_V1",
        "requestNumber": "RequestRevision",
        "postDateTime": "06/05/2019 05:45:51",
        "loanNumber": "0100697275",
        "s3URI": "dev/appraisal/ArchwellOutbound_c06edad8-4e8b-465b-908a-c1f3ac522f3a.xml",
        "status": "ACK"
    },
    {
        "processName": "ARCHWELL_APPRAISAL_V1",
        "requestNumber": "RequestRevision",
        "postDateTime": "06/05/2019 05:25:09",
        "loanNumber": "0100697275",
        "s3URI": "dev/appraisal/ArchwellOutbound_c1c68f13-cfbc-4c08-a328-201ccb122b39.xml",
        "status": "ACK"
    }
]



// We need a function which handles requests and send response
function handleRequest(req, res) {
    if (req.url.includes('messages')) {
        res.statusCode = 200;
    } else {
        res.statusCode = 404;
    }

    res.setHeader('Content-Type', 'application/json');
    setTimeout(
        () => {
            res.end(JSON.stringify(DATA));
        }, 2000
    )

    // response.end('Server working properly. Requested URL : ' + request.url);
}

// Create a server
var myFirstServer = http.createServer(handleRequest);

// Start the server !
myFirstServer.listen(PORT, function () {
    // Callback triggered when server is successfully listening. Hurray!
    console.log("Server listening on: http://localhost:%s", PORT);
});
// The createServer method returns a new instance of http.Server. To create our server, you need to specify a port and use the listen method, this cause the server to accept connections on the specified handle.

// To start the server use the following command in your Node.js command prompt:
// const server = http.createServer((req, res) => {
//     res.statusCode = 200;
//     res.setHeader('Content-Type', 'application/json');
//     setTimeout(
//         () => {
//             res.end(JSON.stringify(DATA));
//         }, 2000
//     )
// });

// server.listen(port, hostname, () => {
//     console.log(`Server running at http://${hostname}:${port}/`);
// });