define(function(require) {

  var APILocation = require('app/apiLocations');
  require('angular-ui-router');
  require('app/modules/contacorrente/services/module');
  require('app/modules/contacorrente/controllers/module');

  return require('angular')
    .module('app.contacorrente', [
      'ui.router',
      'app.contacorrente.controllers',
      'app.contacorrente.services',
      'gumga.core'
    ])
    .config(function($stateProvider, $httpProvider) {
      $stateProvider
        .state('contacorrente.list', {
          url: '/list',
          templateUrl: 'app/modules/contacorrente/views/list.html',
          controller: 'ContaCorrenteListController'
        })
        .state('contacorrente.insert', {
          url: '/insert',
          templateUrl: 'app/modules/contacorrente/views/form.html',
          controller: 'ContaCorrenteFormController',
          resolve: {
            entity: ['$stateParams', '$http', function($stateParams, $http) {
              return $http.get(APILocation.apiLocation + '/api/contacorrente/new');
            }]
          }
        })
        .state('contacorrente.edit', {
          url: '/edit/:id',
          templateUrl: 'app/modules/contacorrente/views/form.html',
          controller: 'ContaCorrenteFormController',
          resolve: {
            entity: ['$stateParams', '$http', function($stateParams, $http) {
              return $http.get(APILocation.apiLocation + '/api/contacorrente/' + $stateParams.id);
            }]
          }
        });
    })

});