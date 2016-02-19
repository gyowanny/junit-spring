define([], function() {

  ContaCorrenteListController.$inject = ['$scope', 'ContaCorrenteService', 'gumgaController'];

  function ContaCorrenteListController($scope, ContaCorrenteService, gumgaController) {

    gumgaController.createRestMethods($scope, ContaCorrenteService, 'contacorrente');
    ContaCorrenteService.resetDefaultState();

    $scope.contacorrente.execute('get');

    $scope.tableConfig = {
      columns: 'titular,button',
      checkbox: true,
      columnsConfig: [{
        name: 'titular',
        title: '<span gumga-translate-tag="contacorrente.titular">titular</span>',
        content: '{{$value.titular}}',
        sortField: 'titular'
      }, {
        name: 'button',
        title: ' ',
        content: '<span class="pull-right"><a class="btn btn-primary btn-sm" ui-sref="contacorrente.edit({id: {{$value.id}} })"><i class="glyphicon glyphicon-pencil"></i></a></span>'
      }]
    };

  };
  return ContaCorrenteListController;
});