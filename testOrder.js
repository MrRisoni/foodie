const axios = require('axios')

const reactState = require('./reactState.json');

axios
  .post("http://localhost:8080/api/order/update_basket", reactState)
  .then(responseObj => {
    console.log(responseObj.data);
  })
  .catch(err => {
    console.log(err);
  });