package com.lama_development.java_demo.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.lama_development.java_demo.repository.*;
import com.lama_development.java_demo.service.*;
import com.lama_development.java_demo.dto.*;

@Controller //will be state/session
public class UserController {
    private static final String userSessionKey = "user";

    @PostMapping("/dologin")
    // public ResponseEntity<String> userLogin(HttpSession session,
    // @RequestHeader("Authorization") String encodedAuth, HttpServletResponse
    // response) {
    public ResponseEntity<String> userLogin(HttpServletRequest request, HttpServletResponse response,
            @RequestHeader("Authorization") String encodedAuth) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("COOOKIE: " + cookie);
            }
        }
        System.out.println("FUCK YOU");
        System.out.println(encodedAuth);
        User user = getCredentials(encodedAuth);
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("SESSION IS NULL: " + session);
        } else {
            System.out.println("SESSION IS not NULL: " + session);
        }

        if (user == null) {
            return ResponseEntity.badRequest().header("Bad request no credentials").build();
        }
        if (session != null) {
            System.out.println("SESSION NOT NULL: " + session);
        }
        session = request.getSession(true);
        session.setMaxInactiveInterval(15*60);
        session.setAttribute("user", user.userName);
        System.out.println("IS SESSION NULL?: " + request.getSession(false));
        /*
         * Cookie cookie = new Cookie("platform", "mobile");
         * 
         * if (user.userName == "DAVID") { session.setAttribute("username",
         * user.firstName);
         * 
         * // expires in 7 days cookie.setMaxAge(7 * 24 * 60 * 60);
         * 
         * // optional properties cookie.setSecure(true); cookie.setHttpOnly(true);
         * cookie.setPath("/");
         * 
         * // add cookie to response response.addCookie(cookie);
         * 
         * // TODO: add your login logic here String jwtToken = "NOT_AVAILABLE"; } else
         * { session.setAttribute("Fail", "Failed to login"); }
         */
        // return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
        // cookie.toString()).build();
        return ResponseEntity.ok("BKAKAK");

    }

    @GetMapping("/dologin")
    public ResponseEntity<String> userLogin() {
        /*
         * byte[] decodedBytes = Base64.getDecoder().decode(encodedAuth); String
         * decodedString = new String(decodedBytes); System.out.println(decodedString);
         * User user = new User(); Cookie cookie = new Cookie("platform", "mobile");
         */
        return ResponseEntity.ok().header("Fy dig").build();

    }

    /**
     * Will convert an basic authstring to user with username and password.
     * 
     * @param authString Basic64 string
     * @return User with the specified credentials, or null if not a valid
     *         credential/auth-header.
     */
    public User getCredentials(String authString) {
        int lengthLeast = "Basic ".length();
        if (authString.length() >= lengthLeast) {
            authString = authString.substring(lengthLeast);
            byte[] decodedBytes = Base64.getDecoder().decode(authString);
            String decodedString = new String(decodedBytes);
            System.out.println(decodedString);
            lengthLeast = decodedString.indexOf(":");
            if (lengthLeast < 0)
                return null;
            User user = new User();
            user.userName = decodedString.substring(0, lengthLeast);
            user.password = decodedString.substring(lengthLeast + 1);
            System.out.println("USERNAME: " + user.userName);
            System.out.println("Password: " + user.password);
            return user;

        }
        return null;
    }
    /*
     * @PostMapping("/login") public ResponseEntity<String> login(String username,
     * String password) {
     * 
     * AppUserRecord appUserRecord =
     * this.dsl.selectFrom(APP_USER).where(APP_USER.EMAIL.eq(username)).fetchOne();
     * 
     * if (appUserRecord != null) { boolean pwMatches =
     * this.passwordEncoder.matches(password, appUserRecord.getPasswordHash()); if
     * (pwMatches && appUserRecord.getEnabled().booleanValue()) {
     * 
     * String sessionId = this.tokenService.createToken();
     * 
     * AppSessionRecord record = this.dsl.newRecord(APP_SESSION);
     * record.setId(sessionId); record.setAppUserId(appUserRecord.getId());
     * record.setValidUntil(LocalDateTime.now().plus(this.appProperties.
     * getCookieMaxAge())); record.store();
     * 
     * ResponseCookie cookie = ResponseCookie.from(AuthCookieFilter.COOKIE_NAME,
     * sessionId)
     * .maxAge(this.appProperties.getCookieMaxAge()).sameSite("Strict").path("/").
     * httpOnly(true) .secure(this.appProperties.isSecureCookie()).build();
     * 
     * return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
     * .body(appUserRecord.getAuthority()); } } else {
     * this.passwordEncoder.matches(password, this.userNotFoundEncodedPassword); }
     * 
     * return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); }
     */
    /*
     * @PostMapping("/user/register") public Phone createPhone(@RequestBody Phone
     * phoneHttpServletResponse) { return phoneRepository.save(phone); }
     * 
     * @@PostMapping("/user/login") public Phone createPhone(@RequestBody Phone
     * phoneHttpServletResponse) { return phoneRepository.save(phone); }
     * 
     * @PutMapping("/user/logout") public Phone createPhone(@RequestBody Phone
     * phoneHttpServletResponse) { return phoneRepository.save(phone); }
     * 
     * @GetMapping("/user/is-authenticated"){
     * 
     * }
     */
}
