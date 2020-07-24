<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * UsersFavoriteRestaurants
 *
 * @ORM\Table(name="users_favorite_restaurants", uniqueConstraints={@ORM\UniqueConstraint(name="user_id_2", columns={"user_id", "restaurant_id"})}, indexes={@ORM\Index(name="user_id", columns={"user_id"}), @ORM\Index(name="restaurant_id", columns={"restaurant_id"})})
 * @ORM\Entity
 */
class UsersFavoriteRestaurants
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \Restaurants
     *
     * @ORM\ManyToOne(targetEntity="Restaurants")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="restaurant_id", referencedColumnName="id")
     * })
     */
    private $restaurant;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="user_id", referencedColumnName="id")
     * })
     */
    private $user;


}
