<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Suburbs
 *
 * @ORM\Table(name="suburbs", indexes={@ORM\Index(name="index_suburbs_on_cities_id", columns={"cities_id"})})
 * @ORM\Entity
 */
class Suburbs
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string|null
     *
     * @ORM\Column(name="name", type="string", length=255, nullable=true)
     */
    private $name;

    /**
     * @var \Cities
     *
     * @ORM\ManyToOne(targetEntity="Cities")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="cities_id", referencedColumnName="id")
     * })
     */
    private $cities;


}
