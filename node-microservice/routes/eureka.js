var express = require('express');
var router = express.Router();
var os = require('os');

var networkInt = os.networkInterfaces();
//var localIp =  networkInt.Ethernet[1].address;//windows
//var localIp =  networkInt.eth0[0].address; //linux

const Eureka = require('eureka-js-client').Eureka;

const eureka = new Eureka({
    instance: {
        app: 'node-service',
        hostName: 'localhost',
        ipAddr: '172.0.0.1',
      preferIpAddress :'true',
        statusPageUrl: 'http://'+'localhost'+':3000/',
        port: {
            '$': 3000,
            '@enabled': 'true',
        },
        vipAddress: 'node-service',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        host: 'eureka',
        port: 8761,
        servicePath: '/eureka/apps/',
maxRetries: 10,
      requestRetryDelay: 2000
    }
});
eureka.logger.level('debug');
eureka.start(function(error){
    console.log(error || 'complete');
});

router.get('/start', function(req, res){
    res.send('starting eureka');
    eureka.start(function(error){
        console.log(error || 'complete');
    });
});

router.get('/stop', function(req, res){
    res.send('stoping eureka');
    console.log('stoping eureka');
    eureka.stop();
});

module.exports = router;
