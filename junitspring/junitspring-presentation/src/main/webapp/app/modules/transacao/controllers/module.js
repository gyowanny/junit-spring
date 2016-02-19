define(function (require) {
    var angular = require('angular');
    require('app/modules/transacao/services/module');
    require('angular-ui-router');

    return angular.module('app.transacao.controllers', ['app.transacao.services','ui.router'])
        .controller('TransacaoFormController', require('app/modules/transacao/controllers/TransacaoFormController'))
        .controller('TransacaoListController', require('app/modules/transacao/controllers/TransacaoListController'));
});