<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
    <meta charset="UTF-8">
    <title>공지사항목록</title>

    <link href="css/layout.css" type="text/css" rel="stylesheet" />
    <link href="css/index.css" type="text/css" rel="stylesheet" />
</head>

<body>
    <!-- header 부분 -->

    <header id="header">
        
        <div class="content-container">
            <!-- ---------------------------<header>--------------------------------------- -->

            <h1 id="logo">
                <a href="/index.html">
                    <img src="/images/logo.png" alt="뉴렉처 온라인" />

                </a>
            </h1>

            <section>
                <h1 class="hidden">헤더</h1>

                <nav id="main-menu">
                    <h1>메인메뉴</h1>
                    <ul>
                        <li><a href="/guide">학습가이드</a></li>

                        <li><a href="/course">강좌선택</a></li>
                        <li><a href="/answeris/index">AnswerIs</a></li>
                    </ul>
                </nav>

                <div class="sub-menu">

                    <section id="search-form">
                        <h1>강좌검색 폼</h1>
                        <form action="/course">
                            <fieldset>
                                <legend>과정검색필드</legend>
                                <label>과정검색</label>
                                <input type="text" name="q" value="" />
                                <input type="submit" value="검색" />
                            </fieldset>
                        </form>
                    </section>

                    <nav id="acount-menu">
                        <h1 class="hidden">회원메뉴</h1>
                        <ul>
                            <li><a href="/index.html">HOME</a></li>
                            <li><a href="/member/login.html">로그인</a></li>
                            <li><a href="/member/agree.html">회원가입</a></li>
                        </ul>
                    </nav>

                    <nav id="member-menu" class="linear-layout">
                        <h1 class="hidden">고객메뉴</h1>
                        <ul class="linear-layout">
                            <li><a href="/member/home"><img src="/images/txt-mypage.png" alt="마이페이지" /></a></li>
                            <li><a href="/notice/list.html"><img src="/images/txt-customer.png" alt="고객센터" /></a></li>
                        </ul>
                    </nav>

                </div>
            </section>

        </div>
        
    </header>


    <!-- --------------------------- <body> --------------------------------------- -->

    <!-- content 부분 -->



    <div id="visual" class="">
        <div class="content-container">
            <h2 class="hidden">신규 강좌목록</h2>
            <!-- <ul class="mov-button">
			<li class="prev-button">이전</li>
			<li class="next-button">다음</li>
		</ul> -->
            <ul class="banner">


                <li class="banner1">
                    <a href="customer/event/1">
                        <img src="admin/board/event/1/banner-java.png" data-id="1" style="cursor: pointer;" />
                    </a>
                </li>

            </ul>



            <ul class="banner-button-list" style="color:#ffff00; font-size:20px;position:absolute; left:10px; bottom:5px; z-index: 100px; display: flex; flex-direction: row;">
                <li></li>
            </ul>

        </div>

    </div>
    <div id="notice">
        <div class="content-container">
            <span class="title">제대로된 전문가들이 만들어가는 <span style="color:yellow;font-size:15px;">IT PROFESSIONAL <span style="color:#00ffff;">NEW</span>
                    ONLINE <span style="color:#00ffff;">LECTURE</span> MARKET</span></span>
            <!--<a class="detail-button">자세히</a>-->
        </div>
    </div>
    <!-- ----- 공지사항 줄 ------------------------------------------------------------------------------ -->
    <div id="information">
        <div class="content-container">
            <section class="guide">
                <h1 class="title">강의 플레이어 사용방법 안내</h1>
                <div class="margin-top">
                    <a href="customer/faq/1"><img src="images/customer/installInfo.png" /></a>
                </div>
                <!-- <div>
            2
            </div>
            <div>
            3
            </div> -->
            </section>
            <section class="course-info">
                <h1 class="title text-center">뉴렉처 하이브리드 과정 모집</h1>
                <ul class="list">
                    <li>현재 모집 과정이 없습니다.</li>
                </ul>
            </section>
            <section class="notice">
                <h1 class="title">공지사항</h1>
                <ul class="list margin-top">

                    <li>
                        <span class="notice-title">
                            <a href="notice/detail.html">스프링 8강까지의 예제 코드</a>
                        </span>
                        <span>2019-08-18</span>
                    </li>

                    <li>
                        <span class="notice-title">
                            <a href="notice/detail.html">스프링 DI 예제 코드</a>
                        </span>
                        <span>2019-08-15</span>
                    </li>

                    <li>
                        <span class="notice-title">
                            <a href="notice/detail.html">뉴렉쌤 9월 초 국기과정 모집 안내</a>
                        </span>
                        <span>2019-06-11</span>
                    </li>

                    <li>
                        <span class="notice-title">
                            <a href="notice/detail.html">뉴렉처 강의 수강 방식 안내</a>
                        </span>
                        <span>2019-05-24</span>
                    </li>

                    <li>
                        <span class="notice-title">
                            <a href="notice/detail.html">자바 구조적인 프로그래밍 강의 예제 파일</a>
                        </span>
                        <span>2019-04-24</span>
                    </li>

                </ul>
            </section>
        </div>
    </div>

    <!-- ----- 커뮤니티 시작 줄 -------------------------------------------------------------------------------------------- -->



    <!-- ----- 커뮤니티 시작 줄 -------------------------------------------------------------------------------------------- -->
    <!-- <div class="margin-top">
	<div style="height: 170px; margin-top:10px;" class="content-container border">
	</div>
</div> -->

    <!-- ----- 강좌 목록 시작 줄 --------------------------------------------------------------------------------------------------------- -->
    <main id="course">
        <section class="content-container list list-horizontal list-course list-course-index">
            <h1>온라인 <span class="color-orange">단과 과정</span></h1>
            <div>
               
            </div>

            <ul>
                <!-- <li class="item-course normal new">
                    <div>
                        <a href="course/16"><img src="images/course/landing page.png" /></a>
                        
                    </div>
                    <div>
                        <div>
                            <a href="course/16"><span class="text-strong text-ellipsis">멋진 프로그래머가 되기 위한 사전지식</span></a>
                        </div>
                        <div class="price">
                            <span class="normal ">
                                <span class="text-orange text-strong">
                                    0
                                </span> 원
                            </span> <span class="event">



                            </span>
                        </div>
                        <div class="footer text-strong">
                            <span class="writer">선생님 : newlec </span>
                            <span class="update">개설일 : 2019-09-07
                            </span>
                        </div>
                    </div>
                </li>
                <li class="item-course normal new">
                    <div>
                        <a href="course/10"><img src="images/course/html5.png" /></a>
                        
                    </div>
                    <div>
                        <div>
                            <a href="course/10"><span class="text-strong text-ellipsis">웹 표준기반의 웹 퍼블리싱 HTML5 편</span></a>
                        </div>
                        <div class="price">
                            <span class="normal ">
                                <span class="text-orange text-strong">
                                    45,000
                                </span> 원
                            </span> <span class="event">



                            </span>
                        </div>
                        <div class="footer text-strong">
                            <span class="writer">선생님 : newlec </span>
                            <span class="update">개설일 : 2019-09-07
                            </span>
                        </div>
                    </div>
                </li>


                <li class="item-course normal event">
                    <div>
                        <a href="course/8"><img src="images/course/oracle.png" /></a>
                       
                    </div>
                    <div>
                        <div>
                            <a href="course/8"><span class="text-strong text-ellipsis">Oracle SQL 프로그래밍</span></a>
                        </div>
                        <div class="price">
                            <span class="normal deprecated">
                                <span class="text-gray">
                                    44,000
                                </span> 원
                            </span> <span class="event">


                                <span class="color-red text-strong">
                                    0
                                </span>원


                            </span>
                        </div>
                        <div class="footer text-strong">
                            <span class="writer">선생님 : newlec </span>
                            <span class="update">개설일 : 2019-09-07
                            </span>
                        </div>
                    </div>
                </li>
                <li class="item-course normal normal">
                    <div>
                        <a href="course/7"><img src=images/course/spring.png" /></a>
                       
                    </div>
                    <div>
                        <div>
                            <a href="course/7"><span class="text-strong text-ellipsis">스프링 3.x MVC 웹 프로그래밍</span></a>
                        </div>
                        <div class="price">
                            <span class="normal ">
                                <span class="text-orange text-strong">
                                    33,600
                                </span> 원
                            </span> <span class="event">



                            </span>
                        </div>
                        <div class="footer text-strong">
                            <span class="writer">선생님 : newlec </span>
                            <span class="update">개설일 : 2019-09-07
                            </span>
                        </div>
                    </div>
                </li> -->
                <li class="item-course normal event">
                    <div>
                        <a href="course/2"><img src="images/course/java.png" /></a>                        
                    </div>
                    <div>
                        <div>
                            <a href="course/2"><span class="text-strong text-ellipsis">자바 프로그래밍</span></a>
                        </div>
                        <div class="price">
                            <span class="normal deprecated">
                                <span class="text-gray">
                                    22,000
                                </span> 원
                            </span> <span class="event">


                                <span class="color-red text-strong">
                                    0
                                </span>원


                            </span>
                        </div>
                        <div class="footer text-strong">
                            <span class="writer">선생님 : newlec </span>
                            <span class="update">개설일 : 2019-09-07
                            </span>
                        </div>
                    </div>
                </li>


            </ul>

            <div class="more">
                <!-- <span class="border padding">단과 과정 목록 더보기</span> -->
            </div>
        </section>

        <!-- ------- 온라인 패키지 과정 ------------------------------------------------------------------------------------------------- -->

        <div class="content-container">
            <h3 class="-text- center green bold -margin- top">협력업체</h3>
            <ul class="-list- horizontal center -margin- bottom top b20">
                <li><a target="_blank" href="http://www.notepubs.com"><img src="images/notepubs.png" alt="노트펍스" /></a></li>
                <li><a target="_blank" href="http://www.namoolab.com"><img src="images/namoolab.png" alt="나무랩연구소" /></a></li>                
               
            </ul>
        </div>
    </main>
    <script>

    </script>




    <!-- ------------------- <footer> --------------------------------------- -->



    <footer id="footer">
        <div class="content-container">
            <h2 id="footer-logo"><img src="images/logo-footer.png" alt="회사정보"></h2>

            <div id="company-info">
                <dl>
                    <dt>주소:</dt>
                    <dd>서울특별시 </dd>
                    <dt>관리자메일:</dt>
                    <dd>admin@newlecture.com</dd>
                </dl>
                <dl>
                    <dt>사업자 등록번호:</dt>
                    <dd>111-11-11111</dd>
                    <dt>통신 판매업:</dt>
                    <dd>신고제 1111 호</dd>
                </dl>
                <dl>
                    <dt>상호:</dt>
                    <dd>뉴렉처</dd>
                    <dt>대표:</dt>
                    <dd>홍길동</dd>
                    <dt>전화번호:</dt>
                    <dd>111-1111-1111</dd>
                </dl>
                <div id="copyright" class="margin-top">Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
                    Contact admin@newlecture.com for more information</div>
            </div>
        </div>
    </footer>
</body>

</html>