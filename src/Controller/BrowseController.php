<?php
// src/Controller/LuckyController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
//use App\Repository\ProductRepository;
use Doctrine\ORM\EntityManager; 
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class BrowseController  extends AbstractController
{
    public function getRestaurants(): Response
    {

        $repositoryCusine = $this->getDoctrine()->getRepository(\App\Entity\Cuisines::class);
        
      //  var_dump( $repositoryCusine->findAll());

        return $this->render('browse/index.html.twig', [
            'cuisines' => $repositoryCusine->findAll()]);

    }
}