const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/project', { useCreateIndex: true, useNewUrlParser: true });
mongoose.Promise = global.Promise;

module.exports = {
    User: require('../user/user.model')
};
