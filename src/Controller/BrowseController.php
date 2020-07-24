<?php
// src/Controller/LuckyController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
//use App\Repository\ProductRepository;
use Doctrine\ORM\EntityManager; 
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class BrowseController  extends AbstractController
{
    public function getRestaurants(): void
    {

        $repositoryCusine = $this->getDoctrine()->getRepository(\App\Entity\Cuisines::class);
        
        var_dump($repositoryCusine->findAll());
        echo 'heu';
        return;
    }
}