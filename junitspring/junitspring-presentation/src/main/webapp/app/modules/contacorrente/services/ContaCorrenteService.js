define(['app/apiLocations'], function(APILocation) {

  ContaCorrenteService.$inject = ['GumgaRest'];

  function ContaCorrenteService(GumgaRest) {
    var Service = new GumgaRest(APILocation.apiLocation + '/api/contacorrente');

    return Service;
  }

  return ContaCorrenteService;
});