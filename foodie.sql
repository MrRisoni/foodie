-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2020 at 09:52 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodie`
--

-- --------------------------------------------------------

--
-- Table structure for table `cities`
--

CREATE TABLE `cities` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `perfectures_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`id`, `name`, `perfectures_id`) VALUES
(1, 'Αθήνα', 1);

-- --------------------------------------------------------

--
-- Table structure for table `credit_cards`
--

CREATE TABLE `credit_cards` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `type` varchar(4) NOT NULL,
  `bin` varchar(255) DEFAULT NULL,
  `lastfour` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cuisines`
--

CREATE TABLE `cuisines` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cuisines`
--

INSERT INTO `cuisines` (`id`, `name`) VALUES
(2, 'Burger'),
(4, 'Pizza'),
(5, 'Ζυμαρικά'),
(3, 'Κινέζικο'),
(1, 'Σουβλάκι');

-- --------------------------------------------------------

--
-- Table structure for table `donations`
--

CREATE TABLE `donations` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `category_id` tinyint(3) UNSIGNED NOT NULL,
  `active` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `donation_categories`
--

CREATE TABLE `donation_categories` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `title` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL,
  `cuisines_id` bigint(20) DEFAULT NULL,
  `menus_id` bigint(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `name`, `active`, `restaurants_id`, `cuisines_id`, `menus_id`, `price`) VALUES
(1, 'Λουκανικο Καρδιτσας Πιτα Γυρο', 1, 1, 1, 3, '2.80'),
(2, 'Penne arabiata', 1, 3, 5, 5, '8.50');

-- --------------------------------------------------------

--
-- Table structure for table `food_parts`
--

CREATE TABLE `food_parts` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `foods_id` bigint(20) DEFAULT NULL,
  `allow_many` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food_parts`
--

INSERT INTO `food_parts` (`id`, `name`, `foods_id`, `allow_many`) VALUES
(1, 'Πίτα', 1, 0),
(2, 'Συστατικά', 1, 1),
(3, 'Αλοιφές', 1, 1),
(4, 'Πάστα', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `food_part_ingredients`
--

CREATE TABLE `food_part_ingredients` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `food_part_id` bigint(20) NOT NULL,
  `ingredient_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food_part_ingredients`
--

INSERT INTO `food_part_ingredients` (`id`, `food_part_id`, `ingredient_id`) VALUES
(1, 1, 4),
(2, 1, 5),
(3, 1, 6),
(16, 2, 1),
(14, 2, 2),
(13, 2, 3),
(12, 2, 14),
(15, 2, 15),
(7, 3, 7),
(5, 3, 8),
(10, 3, 9),
(6, 3, 10),
(11, 3, 11),
(4, 3, 12);

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL,
  `restaurant_id` bigint(20) NOT NULL,
  `name` varchar(55) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`id`, `restaurant_id`, `name`, `price`) VALUES
(1, 1, 'Τηγανητές', '0.00'),
(2, 1, 'Κρεμμύδι', '0.00'),
(3, 1, 'Onion Rings', '1.20'),
(4, 1, 'Πολύσπορη', '1.00'),
(5, 1, 'Αραβική', '1.00'),
(6, 1, 'Κανονική', '1.00'),
(7, 1, 'Σως', '1.00'),
(8, 1, 'Κέτσαπ', '1.00'),
(9, 1, 'Μουστάρδα', '1.00'),
(10, 1, 'Τζατζίκι', '1.00'),
(11, 1, 'Τυροκαυτερή', '1.00'),
(12, 1, 'BBQ', '1.00'),
(13, 1, 'Ντομάτα', '0.00'),
(14, 1, 'Bacon', '3.00'),
(15, 1, 'Μαϊντανός', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `name`, `restaurants_id`) VALUES
(1, 'Ορεκτικά', 1),
(2, 'Σαλάτες', 1),
(3, 'Τυλιχτά', 1),
(4, 'Τεμάχια', 1),
(5, 'Μερίδες', 1),
(6, 'Αναψυκτικά', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_donations`
--

CREATE TABLE `order_donations` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `category_id` tinyint(3) UNSIGNED NOT NULL,
  `amount` decimal(10,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `base_price` decimal(10,2) DEFAULT NULL,
  `final_price` decimal(10,2) UNSIGNED NOT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `shop_id` bigint(20) NOT NULL DEFAULT 1,
  `comment` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`id`, `order_id`, `base_price`, `final_price`, `food_id`, `shop_id`, `comment`) VALUES
(1, 1, '5.00', '7.80', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_item_ingredients`
--

CREATE TABLE `order_item_ingredients` (
  `id` bigint(20) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `order_items_id` bigint(20) DEFAULT NULL,
  `ingredients_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_item_ingredients`
--

INSERT INTO `order_item_ingredients` (`id`, `price`, `order_items_id`, `ingredients_id`) VALUES
(1, '2.50', 1, 12),
(2, '1.40', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `orxders`
--

CREATE TABLE `orxders` (
  `id` bigint(20) NOT NULL,
  `success` tinyint(1) DEFAULT NULL,
  `final_price` decimal(10,2) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `users_id` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) UNSIGNED NOT NULL DEFAULT 1,
  `pay_method_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orxders`
--

INSERT INTO `orxders` (`id`, `success`, `final_price`, `created_at`, `updated_at`, `users_id`, `address_id`, `pay_method_id`) VALUES
(1, 1, '23.45', '2020-05-23 10:58:37', '2020-05-23 10:58:37', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment_methods`
--

CREATE TABLE `payment_methods` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `title` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_methods`
--

INSERT INTO `payment_methods` (`id`, `title`) VALUES
(1, 'COD'),
(2, 'Credit Card'),
(3, 'Paypal');

-- --------------------------------------------------------

--
-- Table structure for table `perfectures`
--

CREATE TABLE `perfectures` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `perfectures`
--

INSERT INTO `perfectures` (`id`, `name`) VALUES
(1, 'Αττική');

-- --------------------------------------------------------

--
-- Table structure for table `rating_criteria`
--

CREATE TABLE `rating_criteria` (
  `id` smallint(5) UNSIGNED NOT NULL,
  `crit_title` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rating_criteria`
--

INSERT INTO `rating_criteria` (`id`, `crit_title`) VALUES
(2, 'Ποιότητα'),
(1, 'Ταχύτητα παράδοσης');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`) VALUES
(1, 'stage grill'),
(2, 'Kalamaki and Burger Story'),
(3, 'La pasteria'),
(4, 'Mr Dim');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants_cuisines`
--

CREATE TABLE `restaurants_cuisines` (
  `id` bigint(20) NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `restaurants_id` bigint(20) DEFAULT NULL,
  `cuisines_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants_cuisines`
--

INSERT INTO `restaurants_cuisines` (`id`, `active`, `restaurants_id`, `cuisines_id`) VALUES
(1, 1, 1, 1),
(2, 1, 3, 4),
(3, 1, 3, 5),
(4, 1, 4, 3),
(5, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `user_id`, `shop_id`, `created_at`, `comment`) VALUES
(1, 2, 1, '2020-07-24 08:36:20', 'good\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `reviews_rating`
--

CREATE TABLE `reviews_rating` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `review_id` bigint(20) UNSIGNED NOT NULL,
  `criteria_id` smallint(5) UNSIGNED NOT NULL,
  `stars` decimal(2,1) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reviews_rating`
--

INSERT INTO `reviews_rating` (`id`, `review_id`, `criteria_id`, `stars`) VALUES
(1, 1, 1, '4.5'),
(2, 1, 2, '5.0');

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE `shops` (
  `id` bigint(20) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `suburbs_id` bigint(20) DEFAULT NULL,
  `restaurants_id` bigint(20) DEFAULT NULL,
  `address` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`id`, `active`, `suburbs_id`, `restaurants_id`, `address`) VALUES
(1, 1, 2, 1, 'Iakovos'),
(2, 1, 8, 3, 'Ioakim'),
(3, 1, 8, 4, 'Fragikos');

-- --------------------------------------------------------

--
-- Table structure for table `shops_serving_suburbs`
--

CREATE TABLE `shops_serving_suburbs` (
  `sssb_id` bigint(20) UNSIGNED NOT NULL,
  `sssb_shop_id` bigint(20) NOT NULL,
  `sssb_suburb_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shops_serving_suburbs`
--

INSERT INTO `shops_serving_suburbs` (`sssb_id`, `sssb_shop_id`, `sssb_suburb_id`) VALUES
(5, 1, 2),
(1, 2, 2),
(3, 2, 3),
(2, 2, 6),
(4, 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `suburbs`
--

CREATE TABLE `suburbs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cities_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `suburbs`
--

INSERT INTO `suburbs` (`id`, `name`, `cities_id`) VALUES
(2, 'Καλλιθεα', 1),
(1, 'Κιφησια', 1),
(4, 'Μαρούσι', 1),
(5, 'Μοσχάτο', 1),
(8, 'Νέα Σμύρνη', 1),
(6, 'Νέος Κόσμος', 1),
(3, 'Παλαιο Φάληρο', 1),
(7, 'Τζιτζιφιές', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `passwd`, `created_at`, `updated_at`) VALUES
(1, 'vag', 'vag', 'vag', '2020-05-23 10:58:18', '2020-05-23 10:58:18'),
(2, 'vagos', 'vagos', 'vagos', '2020-05-23 10:58:18', '2020-05-23 10:58:18');

-- --------------------------------------------------------

--
-- Table structure for table `users_addresses`
--

CREATE TABLE `users_addresses` (
  `add_id` bigint(20) UNSIGNED NOT NULL,
  `add_user_id` bigint(20) NOT NULL,
  `add_suburb_id` bigint(20) NOT NULL,
  `add_street` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_addresses`
--

INSERT INTO `users_addresses` (`add_id`, `add_user_id`, `add_suburb_id`, `add_street`) VALUES
(1, 1, 2, '45');

-- --------------------------------------------------------

--
-- Table structure for table `users_favorite_restaurants`
--

CREATE TABLE `users_favorite_restaurants` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `restaurant_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_favorite_restaurants`
--

INSERT INTO `users_favorite_restaurants` (`id`, `user_id`, `restaurant_id`) VALUES
(1, 1, 2),
(2, 1, 4),
(3, 2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_cities_on_perfectures_id` (`perfectures_id`);

--
-- Indexes for table `credit_cards`
--
ALTER TABLE `credit_cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `cuisines`
--
ALTER TABLE `cuisines`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `donations`
--
ALTER TABLE `donations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `donation_categories`
--
ALTER TABLE `donation_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_foods_on_restaurants_id` (`restaurants_id`),
  ADD KEY `index_foods_on_cuisines_id` (`cuisines_id`),
  ADD KEY `index_foods_on_menus_id` (`menus_id`);

--
-- Indexes for table `food_parts`
--
ALTER TABLE `food_parts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_food_parts_on_foods_id` (`foods_id`);

--
-- Indexes for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `food_part_id_2` (`food_part_id`,`ingredient_id`),
  ADD KEY `food_part_id` (`food_part_id`),
  ADD KEY `ingredient_id` (`ingredient_id`);

--
-- Indexes for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_menus_on_restaurants_id` (`restaurants_id`);

--
-- Indexes for table `order_donations`
--
ALTER TABLE `order_donations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_order_items_on_food_id` (`food_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `shop_id` (`shop_id`);

--
-- Indexes for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_order_item_ingredients_on_order_items_id` (`order_items_id`),
  ADD KEY `index_order_item_ingredients_on_ingredients_id` (`ingredients_id`);

--
-- Indexes for table `orxders`
--
ALTER TABLE `orxders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_orders_on_users_id` (`users_id`),
  ADD KEY `address_id` (`address_id`),
  ADD KEY `pay_method_id` (`pay_method_id`);

--
-- Indexes for table `payment_methods`
--
ALTER TABLE `payment_methods`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `perfectures`
--
ALTER TABLE `perfectures`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rating_criteria`
--
ALTER TABLE `rating_criteria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `crit_title` (`crit_title`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `restaurants_id` (`restaurants_id`,`cuisines_id`),
  ADD KEY `index_restaurants_cuisines_on_restaurants_id` (`restaurants_id`),
  ADD KEY `index_restaurants_cuisines_on_cuisines_id` (`cuisines_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `shop_id` (`shop_id`);

--
-- Indexes for table `reviews_rating`
--
ALTER TABLE `reviews_rating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `review_id` (`review_id`),
  ADD KEY `criteria_id` (`criteria_id`);

--
-- Indexes for table `shops`
--
ALTER TABLE `shops`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index_shops_on_suburbs_id` (`suburbs_id`),
  ADD KEY `index_shops_on_restaurants_id` (`restaurants_id`);

--
-- Indexes for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  ADD PRIMARY KEY (`sssb_id`),
  ADD UNIQUE KEY `sssb_shop_id_2` (`sssb_shop_id`,`sssb_suburb_id`),
  ADD KEY `sssb_shop_id` (`sssb_shop_id`),
  ADD KEY `sssb_suburb_id` (`sssb_suburb_id`);

--
-- Indexes for table `suburbs`
--
ALTER TABLE `suburbs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`,`cities_id`),
  ADD KEY `index_suburbs_on_cities_id` (`cities_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_addresses`
--
ALTER TABLE `users_addresses`
  ADD PRIMARY KEY (`add_id`),
  ADD KEY `add_user_id` (`add_user_id`),
  ADD KEY `add_suburg_id` (`add_suburb_id`);

--
-- Indexes for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`,`restaurant_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cities`
--
ALTER TABLE `cities`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `credit_cards`
--
ALTER TABLE `credit_cards`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cuisines`
--
ALTER TABLE `cuisines`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `donations`
--
ALTER TABLE `donations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `donation_categories`
--
ALTER TABLE `donation_categories`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food_parts`
--
ALTER TABLE `food_parts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `order_donations`
--
ALTER TABLE `order_donations`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `orxders`
--
ALTER TABLE `orxders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payment_methods`
--
ALTER TABLE `payment_methods`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `perfectures`
--
ALTER TABLE `perfectures`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rating_criteria`
--
ALTER TABLE `rating_criteria`
  MODIFY `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reviews_rating`
--
ALTER TABLE `reviews_rating`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `shops`
--
ALTER TABLE `shops`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  MODIFY `sssb_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `suburbs`
--
ALTER TABLE `suburbs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users_addresses`
--
ALTER TABLE `users_addresses`
  MODIFY `add_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cities`
--
ALTER TABLE `cities`
  ADD CONSTRAINT `fk_rails_467d4ae28f` FOREIGN KEY (`perfectures_id`) REFERENCES `perfectures` (`id`);

--
-- Constraints for table `credit_cards`
--
ALTER TABLE `credit_cards`
  ADD CONSTRAINT `credit_cards_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orxders` (`id`);

--
-- Constraints for table `donations`
--
ALTER TABLE `donations`
  ADD CONSTRAINT `donations_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `donation_categories` (`id`);

--
-- Constraints for table `foods`
--
ALTER TABLE `foods`
  ADD CONSTRAINT `fk_rails_68f95b473c` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `fk_rails_cf2048325b` FOREIGN KEY (`cuisines_id`) REFERENCES `cuisines` (`id`),
  ADD CONSTRAINT `fk_rails_ee56ac7f20` FOREIGN KEY (`menus_id`) REFERENCES `menus` (`id`);

--
-- Constraints for table `food_parts`
--
ALTER TABLE `food_parts`
  ADD CONSTRAINT `fk_rails_364e34fc6f` FOREIGN KEY (`foods_id`) REFERENCES `foods` (`id`);

--
-- Constraints for table `food_part_ingredients`
--
ALTER TABLE `food_part_ingredients`
  ADD CONSTRAINT `food_part_ingredients_ibfk_1` FOREIGN KEY (`food_part_id`) REFERENCES `food_parts` (`id`),
  ADD CONSTRAINT `food_part_ingredients_ibfk_2` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`);

--
-- Constraints for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD CONSTRAINT `ingredients_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `menus`
--
ALTER TABLE `menus`
  ADD CONSTRAINT `fk_rails_151ee1f387` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `order_donations`
--
ALTER TABLE `order_donations`
  ADD CONSTRAINT `order_donations_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `donation_categories` (`id`),
  ADD CONSTRAINT `order_donations_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orxders` (`id`);

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `fk_rails_0eb6a555b3` FOREIGN KEY (`food_id`) REFERENCES `foods` (`id`),
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orxders` (`id`),
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`);

--
-- Constraints for table `order_item_ingredients`
--
ALTER TABLE `order_item_ingredients`
  ADD CONSTRAINT `fk_rails_22d8011845` FOREIGN KEY (`order_items_id`) REFERENCES `order_items` (`id`),
  ADD CONSTRAINT `fk_rails_a9318b8220` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredients` (`id`);

--
-- Constraints for table `orxders`
--
ALTER TABLE `orxders`
  ADD CONSTRAINT `fk_rails_d3f93ab604` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `orxders_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `users_addresses` (`add_id`),
  ADD CONSTRAINT `orxders_ibfk_2` FOREIGN KEY (`pay_method_id`) REFERENCES `payment_methods` (`id`);

--
-- Constraints for table `restaurants_cuisines`
--
ALTER TABLE `restaurants_cuisines`
  ADD CONSTRAINT `fk_rails_8066da1e97` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `fk_rails_d4c5d78350` FOREIGN KEY (`cuisines_id`) REFERENCES `cuisines` (`id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`),
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `reviews_rating`
--
ALTER TABLE `reviews_rating`
  ADD CONSTRAINT `reviews_rating_ibfk_1` FOREIGN KEY (`criteria_id`) REFERENCES `rating_criteria` (`id`),
  ADD CONSTRAINT `reviews_rating_ibfk_2` FOREIGN KEY (`review_id`) REFERENCES `reviews` (`id`);

--
-- Constraints for table `shops`
--
ALTER TABLE `shops`
  ADD CONSTRAINT `fk_rails_ac5ebe5fef` FOREIGN KEY (`suburbs_id`) REFERENCES `suburbs` (`id`),
  ADD CONSTRAINT `fk_rails_dbd5ad31d1` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurants` (`id`);

--
-- Constraints for table `shops_serving_suburbs`
--
ALTER TABLE `shops_serving_suburbs`
  ADD CONSTRAINT `shops_serving_suburbs_ibfk_1` FOREIGN KEY (`sssb_shop_id`) REFERENCES `shops` (`id`),
  ADD CONSTRAINT `shops_serving_suburbs_ibfk_2` FOREIGN KEY (`sssb_suburb_id`) REFERENCES `suburbs` (`id`);

--
-- Constraints for table `suburbs`
--
ALTER TABLE `suburbs`
  ADD CONSTRAINT `fk_rails_fcbc42e279` FOREIGN KEY (`cities_id`) REFERENCES `cities` (`id`);

--
-- Constraints for table `users_addresses`
--
ALTER TABLE `users_addresses`
  ADD CONSTRAINT `users_addresses_ibfk_1` FOREIGN KEY (`add_suburb_id`) REFERENCES `suburbs` (`id`),
  ADD CONSTRAINT `users_addresses_ibfk_2` FOREIGN KEY (`add_user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_favorite_restaurants`
--
ALTER TABLE `users_favorite_restaurants`
  ADD CONSTRAINT `users_favorite_restaurants_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `users_favorite_restaurants_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
