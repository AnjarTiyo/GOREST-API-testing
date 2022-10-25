<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/AnjarTiyo/GOREST-API-testing">
    <img src="https://avatars0.githubusercontent.com/u/19369327?s=400&v=4" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">GoREST.co.in API manual & Automated Testing</h3>

  <p align="center">
    GoREST.co.in API manual and automated testing using Postman & Rest Assured
    <br />
    <a href="https://github.com/AnjarTiyo/GOREST-API-testing/tree/master/src/documentations"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/AnjarTiyo/GOREST-API-testing">View Demo</a>
    ·
    <a href="https://github.com/AnjarTiyo/GOREST-API-testing">Report Bug</a>
    ·
    <a href="https://github.com/AnjarTiyo/GOREST-API-testing">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#feature-tested">Feature Tested</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://qe06-team1.000webhostapp.com/)

It is Group Project regarding Alterra Academy Quality Engineer Immersive Bootcamp Batch 06 on Manual and Automation Testing. We implement gherkin languange as main feature of this test. So it's quite easy to understand what to test and how the test work. 

This project is based on ***[GoRest - GraphQL and REST API for Testing and Prototyping.](https://gorest.co.in)*** which use fake data | real responses | 24/7 online

We use public V1 API version because we can get more testing insight in tester POV.

You can also view our latest test run online ***[HERE](https://qe06-team1.000webhostapp.com/)***


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [Java 1.8](https://www.oracle.com/java/technologies/downloads/)
* [Intellij IDEA](https://www.jetbrains.com/idea/download/)
* [Maven](https://maven.apache.org/download.cgi)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.


### Installation

#### Method 1: Trough terminal (Maven Should be Installed)

1. Clone the repo
   ```sh
   git clone https://github.com/AnjarTiyo/GOREST-API-testing.git
   ```
3. Go to project directory
   ```sh
   cd GOREST-API-testing
   ```
4. run Maven command
   ```sh
   mvn clean verify
   ```
#### Method 2: Trough Intellij IDEA

1. Create New Project
2. Select from "versioning control"
3. Paste https://github.com/AnjarTiyo/GOREST-API-testing.git
4. Select JDK 1.8
5. Select maven
6. Click OK

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

```sh
Feature: Create new users
  Create new resource users with given json data. Because data.email should unique, we use "Lorem" random email generator.

  Scenario: post create new user with valid data
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201 created
    And post create new user json schema
    And API send usersID to dynamic variable
    And assert usersID not 0
```
  
_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- FEATURE TESTED -->
## Resource Tested

Method we implement is HEAD, GET, PUT, PATCH and DELETE. And authorization using ***header Bearer Token*** and ***HTTP Basic Auth***

- [ ] ./users
    - [ ] POST Create new users 
    - [ ] GET users data
    - [ ] PUT update users
    - [ ] DELETE users
- [ ] ./posts
    - [ ] POST create new posts
    - [ ] GET posts
    - [ ] PUT update posts
    - [ ] PATCH update feature
    - [ ] DELETE posts 
- [ ] ./comments
    - [ ] POST create new commets
    - [ ] GET comments
    - [ ] PUT update comments
    - [ ] DELETE comments
- [ ] Misc
    - [ ] HEAD ping server 

See the [open issues](https://github.com/AnjarTiyo/GOREST-API-testing/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Anjar Tiyo Saputro - [LinkedIn](https://www.linkedin.com/in/anjartiyo) - anjar.jog@gmail.com

Bunga Ayu Ferdiyanti - [LinkedIn](https://www.linkedin.com/in/bungaayuferdiyanti) - bungaayu9599@gmail.com

M. Sholikudin Bhasri - sholikudinxtsm211@gmail.com

Project Link: [https://github.com/AnjarTiyo/GOREST-API-testing](https://github.com/AnjarTiyo/GOREST-API-testing)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Alterra Academy](https://academy.alterra.id/)
* [Rest Assured](https://github.com/rest-assured/rest-assured)
* [OUR Mentor - Wisnu Munawar](https://github.com/wisnuwm)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/AnjarTiyo/GOREST-API-testing.svg?style=for-the-badge
[contributors-url]: https://github.com/AnjarTiyo/GOREST-API-testing/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AnjarTiyo/GOREST-API-testing.svg?style=for-the-badge
[forks-url]: https://github.com/AnjarTiyo/GOREST-API-testing/network/members
[stars-shield]: https://img.shields.io/github/stars/AnjarTiyo/GOREST-API-testing.svg?style=for-the-badge
[stars-url]: https://github.com/AnjarTiyo/GOREST-API-testing/stargazers
[issues-shield]: https://img.shields.io/github/issues/AnjarTiyo/GOREST-API-testing.svg?style=for-the-badge
[issues-url]: https://github.com/AnjarTiyo/GOREST-API-testing/issues
[license-shield]: https://img.shields.io/github/license/AnjarTiyo/GOREST-API-testing.svg?style=for-the-badge
[license-url]: https://github.com/AnjarTiyo/GOREST-API-testing/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/anjartiyo
[product-screenshot]: src/documentations/Screenshot_2022-10-07_18_47_33.png
