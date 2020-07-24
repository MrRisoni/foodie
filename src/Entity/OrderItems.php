<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderItems
 *
 * @ORM\Table(name="order_items", indexes={@ORM\Index(name="index_order_items_on_food_id", columns={"food_id"})})
 * @ORM\Entity
 */
class OrderItems
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
     * @ORM\Column(name="price", type="decimal", precision=10, scale=2, nullable=true, options={"default"="NULL"})
     */
    private $price = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="comment", type="text", length=65535, nullable=true, options={"default"="NULL"})
     */
    private $comment = 'NULL';

    /**
     * @var \Foods
     *
     * @ORM\ManyToOne(targetEntity="Foods")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="food_id", referencedColumnName="id")
     * })
     */
    private $food;


}
