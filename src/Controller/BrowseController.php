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
        $repositoryFavorites = $this->getDoctrine()->getRepository(\App\Entity\UsersFavoriteRestaurants::class);

  //var_dump(  $repositoryFavorites->findAll());

      //  var_dump( $repositoryCusine->findAll());

        return $this->render('browse/index.html.twig', [
            'favorites' => $repositoryFavorites->findAll(),
            'cuisines' => $repositoryCusine->findAll()]);

    }
}