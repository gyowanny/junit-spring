define(function(require) {

  var APILocation = require('app/apiLocations');
  require('angular-ui-router');
  require('app/modules/transacao/services/module');
  require('app/modules/transacao/controllers/module');

  return require('angular')
    .module('app.transacao', [
      'ui.router',
      'app.transacao.controllers',
      'app.transacao.services',
      'gumga.core'
    ])
    .config(function($stateProvider, $httpProvider) {
      $stateProvider
        .state('transacao.list', {
          url: '/list',
          templateUrl: 'app/modules/transacao/views/list.html',
          controller: 'TransacaoListController'
        })
        .state('transacao.insert', {
          url: '/insert',
          templateUrl: 'app/modules/transacao/views/form.html',
          controller: 'TransacaoFormController',
          resolve: {
            entity: ['$stateParams', '$http', function($stateParams, $http) {
              return $http.get(APILocation.apiLocation + '/api/transacao/new');
            }]
          }
        })
        .state('transacao.edit', {
          url: '/edit/:id',
          templateUrl: 'app/modules/transacao/views/form.html',
          controller: 'TransacaoFormController',
          resolve: {
            entity: ['$stateParams', '$http', function($stateParams, $http) {
              return $http.get(APILocation.apiLocation + '/api/transacao/' + $stateParams.id);
            }]
          }
        });
    })

});