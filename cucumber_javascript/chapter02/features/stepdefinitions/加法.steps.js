'use strict'

var assert = require('assert');

module.exports = function () {
    var _input;
    var _output;
    this.Given(/^输入 "([^"]*)"$/, function (input, callback) {
        _input = input;
        callback();
    });

    this.When(/^运行计算器$/, function (callback) {
        _output = eval(_input);
        callback();
    });

    this.Then(/^输出 "([^"]*)"$/, function ( output, callback) {
        assert.equal(output, _output);
        callback();
    });
};