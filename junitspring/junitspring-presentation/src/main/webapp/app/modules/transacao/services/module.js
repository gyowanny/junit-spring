define(function(require) {
   require('angular')
   .module('app.transacao.services', [])
   .service('TransacaoService', require('app/modules/transacao/services/TransacaoService'));
});