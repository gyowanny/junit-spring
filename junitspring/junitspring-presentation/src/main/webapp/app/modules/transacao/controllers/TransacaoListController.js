define([], function() {

  TransacaoListController.$inject = ['$scope', 'TransacaoService', 'gumgaController'];

  function TransacaoListController($scope, TransacaoService, gumgaController) {

    gumgaController.createRestMethods($scope, TransacaoService, 'transacao');
    TransacaoService.resetDefaultState();

    $scope.transacao.execute('get');

    $scope.tableConfig = {
      columns: 'data,button',
      checkbox: true,
      columnsConfig: [{
        name: 'data',
        title: '<span gumga-translate-tag="transacao.data">data</span>',
        content: '{{$value.data}}',
        sortField: 'data'
      }, {
        name: 'button',
        title: ' ',
        content: '<span class="pull-right"><a class="btn btn-primary btn-sm" ui-sref="transacao.edit({id: {{$value.id}} })"><i class="glyphicon glyphicon-pencil"></i></a></span>'
      }]
    };

  };
  return TransacaoListController;
});