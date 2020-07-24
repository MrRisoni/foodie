<?php
// src/Controller/LuckyController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
//use App\Repository\ProductRepository;

class BrowseController
{
    public function getRestaurants(): void
    {

        $repositoryCusine = $this->getDoctrine()->getRepository(Cuisines::class);
        
        var_dump($repositoryCusine->findAll());
        echo 'heu';
        return;
    }
}