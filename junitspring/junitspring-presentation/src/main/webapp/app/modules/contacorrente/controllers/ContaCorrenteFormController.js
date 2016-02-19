define([], function() {


  ContaCorrenteFormController.$inject = ['ContaCorrenteService', '$state', 'entity', '$scope', 'gumgaController'];

  function ContaCorrenteFormController(ContaCorrenteService, $state, entity, $scope, gumgaController) {

    gumgaController.createRestMethods($scope, ContaCorrenteService, 'contacorrente');


    $scope.contacorrente.data = entity.data || {};
    $scope.continue = {};

    $scope.contacorrente.on('putSuccess',function(data){
      $state.go('contacorrente.list');
    })
  }

  return ContaCorrenteFormController;
});