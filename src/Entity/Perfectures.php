<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Perfectures
 *
 * @ORM\Table(name="perfectures")
 * @ORM\Entity
 */
class Perfectures
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
     * @ORM\Column(name="name", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $name = 'NULL';


}
