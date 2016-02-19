define(function (require) {
    var angular = require('angular');
    require('app/modules/contacorrente/services/module');
    require('angular-ui-router');

    return angular.module('app.contacorrente.controllers', ['app.contacorrente.services','ui.router'])
        .controller('ContaCorrenteFormController', require('app/modules/contacorrente/controllers/ContaCorrenteFormController'))
        .controller('ContaCorrenteListController', require('app/modules/contacorrente/controllers/ContaCorrenteListController'));
});