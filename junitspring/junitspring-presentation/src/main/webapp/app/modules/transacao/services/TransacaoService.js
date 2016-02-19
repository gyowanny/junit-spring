define(['app/apiLocations'], function(APILocation) {

  TransacaoService.$inject = ['GumgaRest'];

  function TransacaoService(GumgaRest) {
    var Service = new GumgaRest(APILocation.apiLocation + '/api/transacao');

    return Service;
  }

  return TransacaoService;
});