define(function(require) {
   require('angular')
   .module('app.contacorrente.services', [])
   .service('ContaCorrenteService', require('app/modules/contacorrente/services/ContaCorrenteService'));
});