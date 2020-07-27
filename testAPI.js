const axios = require('axios')

const data = {
    foodId:12,
    ingredients : [
    {
        foodPartId:1,
        ingredientId:1
    },
    {
            foodPartId:1,
            ingredientId:21
        }]
}

axios
  .post("http://localhost:8080/api/order/add_basket", data)
  .then(responseObj => {
    console.log(responseObj.data);
  })
  .catch(err => {
    console.log(err);
  });