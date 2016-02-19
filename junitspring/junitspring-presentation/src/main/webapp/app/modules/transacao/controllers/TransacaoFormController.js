define([], function() {


  TransacaoFormController.$inject = ['TransacaoService', '$state', 'entity', '$scope', 'gumgaController', 'ContaCorrenteService'];

  function TransacaoFormController(TransacaoService, $state, entity, $scope, gumgaController, ContaCorrenteService) {

    gumgaController.createRestMethods($scope, TransacaoService, 'transacao');

    gumgaController.createRestMethods($scope, ContaCorrenteService, 'contacorrente');
    $scope.contacorrente.methods.search('titular','');


    $scope.transacao.data = entity.data || {};
    $scope.transacao.data.data= new Date($scope.transacao.data.data);
    $scope.continue = {};

    $scope.transacao.on('putSuccess',function(data){
      $state.go('transacao.list');
    })
  }

  return TransacaoFormController;
});