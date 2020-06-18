# 스프링 Security architecture
```java
Spring Security Architecture
학습 목표
스프링 시큐리티를 처음 배우는 사람 또는 적어도 한 번은 적용해본 사람을 기준으로 "가장 기본이자 뼈대인 구조를 이해한다"는 학습 목표가 있다.
수 많은 블로그를 참고하면서 이해가 가지 않던 부분을 필자가 학습해 본 방법(로그인 동작으로 살펴보는 방법)으로 구조와 개념을 확립하고자 한다.

용어 정리
스프링 시큐리티에서는 "인증"과 "권한"을 분리하여 체크할 수 있도록 구조를 만들었다.

Authentication(인증) : 'A'라고 주장하는 주체(user, subject, principal)가 'A'가 맞는지 확인하는 것
코드에서 Authentication : 인증 과정에 사용되는 핵심 객체
ID/PASSWORD, JWT, OAuth 등 여러 방식으로 인증에 필요한 값이 전달되는데 이것을 하나의 인터페이스로 받아 수행하도록 추상화 하는 

역할의 인터페이스다.
Authorization(권한) : 특정 자원에 대한 권한이 있는지 확인하는 것
→ 프로세스상 신분 "인증"을 거치고 신분 인증이 되었으면 권한이 있는지 확인 후, 서버 자원에 대해서 접근할 수 있게 되는 순서다.
이 권한 과정은 애플리케이션에서 굉장히 여러 번 일어난다.
id/password, 공인인증서, 지문 등으로 로그인을 하는 것은 '인증'에 해당한다.
Credential(증명서) : 인증 과정 중, 주체가 본인을 인증하기 위해 서버에 제공하는 것. (ID, Password 같은 것)
용어가 정확히 뭔지 몰라도 괜찮다. 전부다 아는게 목적이 아니라 스프링 시큐리티 기본 뼈대를 아는게 목적이기 때문이다. 

(+ 아래 글을 읽으면서 해소할 수 있기를...)

위의 그림을 별도의 창으로 띄워서 같이 보면 아래 글을 이해하는데 도움이 됩니다.

로그인 과정 살펴보기
AuthenticationFilter, DelegatingFilterProxy
우선 클라이언트(브라우저)로 부터 요청(Request)이 오면, 그 요청은 ApplicationFilter 객체들로 먼저 가게된다. 

(DispatcherServlet(Front Controller)에는 아직 도달하지도 않은 상태)

ApplicationFilter들을 거치다가 DelegatingFilterProxyRegistrationBean이라는 필터는 만나게 된다.

이 필터는 DelegatingFilterProxy라는 클래스로 만들어진 스프링 빈(Bean)을 등록시켜주는 역할을 한다.

→ 스프링 부트에서는 @EnableAutoConfiguration annotation을 이용해서 SecurityFilterAutoConfiguration클래스를 로드하고 디폴트로

이름이 "springSecurityFilterChain" 빈을 등록해준다.

그래서 이 때, 스프링 시큐리티가 만든 DelegatingFilterProxy 클래스인 "springSecurityFilterChain"이라는 이름의 스프링 빈을 

등록하고 이후에는 이 DelegatingFilterProxy(springSecurityFilterChain)가 필터로 동작하게 된다.

→ 구체적으로는 DelegatingFilterProxy가 처리를 위임하는 필터 클래스는 "FilterChainProxy"다. 이 클래스 내부에 체인으로 등록된

필터를 순서대로 수행하는 것이다.

(DelegatingFilterProxy → FilterChainProxy → List 구조)

→ 앞에서 스프링 시큐리티가 만든 DelegatingFilterProxy라고 했는데 스프링 부트를 기준으로 설명해서 그렇고 그냥 스프링에서는 

아래와 같이 직접 web.xml파일에 필터를 등록을 한다.

<filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
그러면 "springSecurityFilterChain"이라는 필터 객체는 어떻게 동작하느냐?

springSecurityFilterChain은 스프링에서 보안과 관련된 여러 필터 리스트를 갖고 있는 객체로 필터 리스트(List)를 순회하면서 필터링을 실시한다.

(이 필터 리스트가 AuthenticationFilter들이다. 이 또한 스프링시큐리티가 자동으로 생성한다.)

AuthenticationFilter 리스트 (위에서 아래 순서로 동작한다. (리스트니까 순서가 있지))
WebAsyncManagerIntegrationFilter
SpringSecurityContextHolder는 ThreadLocal기반(하나의 쓰레드에서 SecurityContext 공유하는 방식)으로 동작하는데, 

비동기(Async)와 관련된 기능을 쓸 때에도 SecurityContext를 사용할 수 있도록 만들어주는 필터
SecurityContextPersistenceFilter
SecurityContext가 없으면 만들어주는 필터
SecurityContext는 Authentication 객체를 보관하는 보관 인터페이스다. (구현체가 있어야겠지)
HeaderWriterFilter
응답(Response)에 Security와 관련된 헤더 값을 설정해주는 필터
CsrfFilter
CSRF 공격을 방어하는 필터
LogoutFilter
로그아웃 요청을 처리하는 필터
DefaultLogoutPageGeneratingFilter가 로그아웃 기본 페이지를 생성함
UsernamePasswordAuthenticationFilter → username, password를 쓰는 form기반 인증을 처리하는 필터.
AuthenticationManager를 통한 인증 실행
성공하면, Authentication 객체를 SecurityContext에 저장 후 AuthenticationSuccessHandler 실행
실패하면 AuthenticationFailureHandler 실행
RequestCacheAwareFilter
인증 후, 원래 Request 정보로 재구성하는 필터
SecurityContextHolderAwareRequestFilter
AnonymousAuthenticationFilter
이 필터에 올 때까지 앞에서 사용자 정보가 인증되지 않았다면, 이 요청은 익명의 사용자가 보낸 것으로 판단하고 처리한다.

(Authentication 객체를 새로 생성함(AnonymousAuthenticationToken))
SessionManagementFilter
세션 변조 공격 방지 (SessionId를 계속 다르게 변경해서 클라이언트에 내려준다)
유효하지 않은 세션으로 접근했을 때 URL 핸들링
하나의 세션 아이디로 접속하는 최대 세션 수(동시 접속) 설정
세션 생성 전략 설정
ExceptionTranslationFilter
앞선 필터 처리 과정에서 인증 예외(AuthenticationException) 또는 인가 예외(AccessDeniedException)가 발생한 경우, 해당 

예외를 캐치하여 처리하는 필터 (모든 예외를 다 이 필터에서 처리하는 건 아님)
FilterSecurityInterceptor
인가(Authorization)를 결정하는 AccessDecisionManager에게 접근 권한이 있는지 확인하고 처리하는 필터
→ 간단하게 AuthenticationFilter들을 소개했지만 대충 의미만 알고 넘어간다.

다시 돌아와서 "springSecurityFilterChain"이라는 필터가 갖고 있는 필터 중 하나로 "UsernamePasswordAuthenticationFilter"라는 필터가 있다.

이 필터가 우리가 일반적이라고 생각하는 아이디, 패스워드를 이용한 인증을 담당하는 필터다.

만약, 아이디 패스워드가 아닌 OAuth2.0을 이용한 인증을 하려고 할 때는 어떻게 동작할까? "UsernamePasswordAuthenticationFilter"는

OAuth2.0 인증을 실시할 수 없으니 인증되지 않은 채로 다음 필터를 넘어갈 것이다.

그 후 다른 필터인 "OAuth2ClientAuthenticationProcessingFilter"라는 필터에서 OAuth2.0을 이용한 인증을 시켜줄 것이다. 

(이런 필터는 위에 없었는데? → OAuth를 쓰겠다고 설정하면 스프링 시큐리티가 생성해줌)

필터 체인이란 이런 메커니즘이다. 여러 필터를 거치면서 앞 선 어떠한 필터에서 인증이 완료되면 해당 요청(Request)은 "인증된 요청"이 되는 것이다.

모든 필터를 거쳤는데 전부 다 인증에 실패하면 어떻게 될까? "인증되지 않은 요청"이 되는 것뿐이다.

그러면 인증이 안 됐으니까 해당 요청이 접근 권한이 없으므로 그에 따른 처리를 해주면 된다. 예를 들어 회원가입 페이지로 

:redirect 하거나 Http Error Code : 403에 대한 처리 등을 하면 된다.

UsernamePasswordAuthenticationFilter
이제 앞 단에서 필터 체인으로 어떤 과정을 거쳤는지 알았다.

요청에 대한 인증은 UsernamePasswordAuthenticationFilter가 담당한다고 했다.

UsernamePasswordAuthenticationFilter가 어떻게 동작하는지는 아래 코드와 함께 보도록 한다.

public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            if (username == null) {
                username = "";
            }

            if (password == null) {
                password = "";
            }

            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }
UsernamePasswordAuthenticationFilter 클래스 내의 attemptAuthentication(request, response) 메서드를 보면, 요청으로부터

username과 password를 얻어오고 그 값으로 UsernamePasswordAuthenticationToken(Authentication)을 생성한다.

그 다음에 참조하고 있던 AuthenticationManager(구현체인 ProviderManager)에게 인증을 진행하도록 위임한다.

→ UsernamePasswordAuthenticationToken 은 Authentication 인터페이스의 구현체다.

참고로 Authentication(Interface)을 구현한 구현체여야만 AuthenticationManager에서 인증 과정을 수행할 수 있다.

잠깐 딴 길로 새서... 스프링 시큐리티를 이용하는 커스텀한 인증 절차를 만드려면 어떻게 해야할까?

→ UsernamePasswordAuthenticationFilter와 유사한 커스텀 필터를 만들고, 그 필터내에서 Authentication 인터페이스를 구현한 

커스텀 클래스의 객체(토큰)를 만들어서 AuthenticationManager에 인증해달라고 던져주면 된다. (물론 뒤에서 말할 실질적으로

인증을 담당할 객체도 만들어야한다만...)

다시 흐름으로 돌아와보면, 이제 AuthenticationManager가 인증을 해주는 데까지 왔다.

이제 AuthenticationManager가 무엇인지를 먼저 알아보고 동작을 살펴볼 것이다.

→ 앞으로는 Authentication 인터페이스를 구현한 구현체 클래스(ex. UsernamePasswordAuthenticationToken)의 객체를 편의상 

Authentication 객체라고 부르겠다.

AuthenticationManager, ProviderManager, AuthenticationProvider
AuthenticationManager (Interface)
authenticate(Authentication):Authentication → Authentication 객체를 받아 인증하고 인증되었다면 인증된 Authentication 

객체를 돌려주는 메서드를 구현하도록 하는 인터페이스다.

이 메서드를 통해 인증되면 isAuthenticated(boolean)값을 TRUE로 바꿔준다.

ProviderManager (Class)
AuthenticationManager의 구현체로 스프링에서 인증을 담당하는 클래스로 볼 수 있다.

(스프링 시큐리티가 생성하고 등록하고 관리하는 스프링 빈이므로 직접 구현할 필요가 없음)

하지만 직접 인증 과정을 진행하는게 아니라 멤버 변수로 가지고 있는 AuthenticationProvider들을에게 인증을 위임처리하고 그 중에 

하나의 AuthenticationProvider(명확하게는 AuthenticationProvider를 구현한 클래스)객체가 인증 과정을 거쳐서 인증에 성공하면 

요청에 대해서 ProviderManager가 인증이 되었다고 알려주는 방식이다.

인증이 되었다고 알려주는 건 AuthenticationManager 인터페이스의 메서드인 authenticate() 메서드의 리턴 값인 Authentication객체 

안에 인증 값을 넣어주는 것으로 처리한다.

AuthenticationProvider (Interface)
authenticate(Authentication):Authentication → 앞서 AuthenticationManager에서 봤던 메서드와 똑같은 메서드로 인증과정이 

이 메서드를 통해 진행된다.

supports(Class<?>):boolean → 앞에서 필터에서 보내준 Authentication 객체를 이 AuthenticationProvider가

소화

인증 가능한 클래스인지 확인하는 메서드다.

→ UsernamePasswordAuthenticationToken이 ProviderManager에 도착한다면 ProviderManager는 자기가 갖고 있는 AuthenticationProvider

목록을 순회하면서 '너가 이거 해결해줄 수 있어?' 하고 물어보고(supports()) 해결 가능하다고 TRUE를 리턴해주는 AuthenticationProvider에게

authenticate() 메서드를 실행한다. (아래에 ProviderManager.class 내의 authenticate() 메서드를 가져왔으니 앞서 말한 동작을 확인해보면

도움될 것이다.)

public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    Class<? extends Authentication> toTest = authentication.getClass();//리플렉션으로 타입을 찾고
    AuthenticationException lastException = null;
    AuthenticationException parentException = null;
    Authentication result = null;
    Authentication parentResult = null;
    boolean debug = logger.isDebugEnabled();
    Iterator var8 = this.getProviders().iterator();

    while(var8.hasNext()) {
        AuthenticationProvider provider = (AuthenticationProvider)var8.next();
        if (provider.supports(toTest)) {//여기서 처리가능한지 물어보고
            if (debug) {
                logger.debug("Authentication attempt using " + provider.getClass().getName());
            }

            try {
                result = provider.authenticate(authentication);//가능하다하면 여기서 인증
                if (result != null) {
                    this.copyDetails(authentication, result);
                    break;
                }
            } catch (AccountStatusException var13) {
                this.prepareException(var13, authentication);
                throw var13;
            } catch (InternalAuthenticationServiceException var14) {
                this.prepareException(var14, authentication);
                throw var14;
            } catch (AuthenticationException var15) {
                lastException = var15;
            }
        }
    }
        //...생략...
}
여기까지의 동작 흐름 정리
앞에서 UsernamePasswordAuthenticationFilter가 요청을 가로채서 UsernamePasswordAuthenticationToken(Authentication) 객체를 AuthenticationManager에게 넘겼다.

실질적으로는 AuthenticationManager인터페이스를 구현한 ProviderManager에게 넘겼다.

ProviderManager는 여러 AuthenticationProvider들을 순회하면서 UsernamePasswordAuthenticationToken을 처리해줄 

AuthenticationProvider를 찾는다.

찾으면 해당 객체에게 인증 과정을 처리해달라고 할 것이다.

→ 여기 까지 흐름이다. 그러면 우리가 해야할 일은 무엇인가? AuthenticationProvider는 인터페이스다. 따라서 이 인터페이스를 구현한

클래스를 만들어서 ProviderManager가 그 클래스의 객체에게 인증을 위임하도록 하면, 내가 만든 그 클래스가 인증 처리를 할 수 있게된다.

쉽게 말해서 AuthenticationProvider 인터페이스를 구현한 클래스를 만들어서 거기서 인증하면 끝난다. 이말이다.

AbstractUserDetailsAuthenticationProvider
AuthenticationProvider 인터페이스를 구현한 클래스를 구현하면 되나했더니? 스프링 시큐리티가 아름답게 또 미리 반쯤 구현해놓은 

반제품을 만들어준다. (역시 프레임워크... 근데 잘 안 쓰는 듯하다. 쓸데없는 내용이라 여기고 이 부분은 넘어가도 좋다.)

바로 "AbstractUserDetailsAuthenticationProvider"라는 추상클래스다. 이 클래스가 이미 AuthenticationProvider 인터페이스를 

구현해놨기 때문에 우리는 이 클래스를 상속받은 클래스를 만들어서 구현해주면 된다. (심지어 아래에 코드처럼 authenticate()같은 

핵심메서드도 구현해놨다. 대신 템플릿 메서드 디자인 패턴을 사용했기 때문에 추상메서드인 retrieveUser()메서드는 상속으로 구현해야한다.)

public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, () -> {
        return this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports", "Only UsernamePasswordAuthenticationToken is supported");
    });
    //authentication에서 username을 가져온다.
    String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
    boolean cacheWasUsed = true;
    //캐시 확인
    UserDetails user = this.userCache.getUserFromCache(username);
    if (user == null) {
        cacheWasUsed = false;
        try {
            //캐시에 없을 경우 user객체를 찾아올 메서드(추상 메서드)
            user = this.retrieveUser(username, (UsernamePasswordAuthenticationToken)authentication);
        } catch (UsernameNotFoundException var6) {
            this.logger.debug("User '" + username + "' not found");
            if (this.hideUserNotFoundExceptions) {
                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
            }
            throw var6;
        }
        Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
    }
    //UserDatailsChecker 부분은 이 Authentication 객체 자체가 유효한지 앞,뒤로 검사하는 것.
    try {
        this.preAuthenticationChecks.check(user);
        //추상 메서드로 커스텀한 유효성 체크 로직을 여기서 추가할 수 있다.
        this.additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken)authentication);
    } catch (AuthenticationException var7) {
        if (!cacheWasUsed) {
            throw var7;
        }
        cacheWasUsed = false;
        user = this.retrieveUser(username, (UsernamePasswordAuthenticationToken)authentication);
        this.preAuthenticationChecks.check(user);
        this.additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken)authentication);
    }

    this.postAuthenticationChecks.check(user);
    if (!cacheWasUsed) {
        this.userCache.putUserInCache(user);
    }

    Object principalToReturn = user;
    if (this.forcePrincipalAsString) {
        principalToReturn = user.getUsername();
    }
    //인증이 완료되었으면 인증된 Authentication 객체를 다시 만들어서 리턴해줘야 한다.
    return this.createSuccessAuthentication(principalToReturn, authentication, user);
}
retrieveUser(username, authentication) 메서드를 구현할 때의 핵심을 여기서 알 수 있다.

인증에 성공했는지 실패했는지 판단은 UserDetailsChecker(preAuthenticationChecks, postAuthenticationChecks, 

추가한 checkers)에서 할 것이므로, retrieve()메서드는 여러 이유로 인증에 실패하면 체커가 실패로 판단할 수 있도록

UserDetails를 리턴할 때 UserDetails의 isAccountNonExpired(), isEnabled(), isAccountNonLocked(), 

isCredentialsNonExpired() 등의 메서드에서 false를 리턴하도록 하면 된다. 아니면 AuthenticationException을 발생시켜도 된다.

AuthenticationProvider 구현하기
일반적인 방법대로 AuthenticationProvider(Interface)의 구현체 즉, 내 방식대로 인증을 담당할 클래스를 구현해보자.

(위에서 본 AbstractUserDetailsAuthenticationProvider는 좋은 샘플이 될 수 있다.)

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication == null){
            throw new InternalAuthenticationServiceException("Authentication is null");
        }
        String username = authentication.getName();
        if(authentication.getCredentials() == null){
            throw new AuthenticationCredentialsNotFoundException("Credentials is null");
        }
    	String password = authentication.getCredentials().toString();
        UserDetails loadedUser = customUserDetailsService.loadUserByUsername(username);
        if(loadedUser == null){
            throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        /* checker */
        if(!loadedUser.isAccountNonLocked()){
            throw new LockedException("User account is locked");
        }
        if(!loadedUser.isEnabled()){
            throw new DisabledException("User is disabled");
        }
        if(!loadedUser.isAccountNonExpired()){
            throw new AccountExpiredException("User account has expired");
        }
        /* 실질적인 인증 */
        if(!passwordEncoder.matches(password, loadedUser.getPassword())){
            throw new BadCredentialsException("Password does not match stored value");
        }
        /* checker */
        if(!loadedUser.isCredentialsNonExpired()){
            throw new CredentialsExpiredException("User credentials have expired");
        }
        /* 인증 완료 */
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(loadedUser, null, loadedUser.getAuthorities());
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        //return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
나름 세심하게 담아보려다가 오히려 이해하는데에 복잡해졌는데, 천천히 코드를 살펴보면 이해할 수 있다.

핵심은 Authentication객체로부터 인증에 필요한 정보(username, password)를 받아오고, userDetailsService 

인터페이스를 구현한 객체(CustomUserDetailsService)로 부터 DB에 저장된 유저 정보를 받아온 후, password를 비교하고 인증이 

완료되면 인증이 완료된 Authentication 객체를 리턴해주는 것이다.

→ 참고로 인증 하기 전/후의 UsernamePasswordAuthenticationToken을 만드는 생성자는 아래와 같다.

//인증 전의 토큰
public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
    super((Collection)null);
    this.principal = principal;
    this.credentials = credentials;
    this.setAuthenticated(false);
}
//인증 후의 토큰
public UsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    this.credentials = credentials;//인증 후에는 비밀번호를 웬만하면 제거하기 때문에 null로 들어온다.
    super.setAuthenticated(true);//인증 완료했다고 넣어주는 게 보인다.
}
UserDetailsService 구현하기
유저 정보를 전달하는 서비스의 인터페이스를 구현해야한다.

CustomUserDetailsService의 코드는 아래와 같다.

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    //...생략
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found '"+ username + "'"));
    }
}
UserRepository는 DB에 유저 정보를 가져오는 JPA구현체다.

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
인증에 필요한 구현체들을 다 만들었으니 이제 구현체들을 시큐리티에 설정하는 방법을 알아본다.

AuthenticationProvider 추가하기
이제 내가 만든 인증 시스템인 CustomAuthenticationProvider를 ProviderManager가 알 수 있게 ProviderManager에게 등록해줘야한다.

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
            .and().httpBasic();
    }
}
위와 같이 시큐리티 설정 클래스로 가서 authenticationProvider를 추가해주면 된다.

(내가 만든 CustomAuthenticationProvider를 스프링 빈(Bean)으로 등록하고 받아와서 설정에 넣으면 된다. 간단하다.)

→ 아래의 코드와 같이 authenticationProvider를 등록하지 않고 userDetailsService만 등록하는 경우도 있는데, 이 경우에 내부

코드로 따라가보면 스프링이 제공하는 DaoAuthenticationProvider를 사용하고 있는 것을 확인할 수 있다.

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //...중략
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
마치며
다음에 해야할 일
스프링 시큐리티의 기본 컨셉, 구조를 이해할 수 있었다.

이제 디테일하게 적용해봐야 할 것들이 많이 남아있다.

예를 들면 다음과 같은 것들이다...

로그인 후에는 어떻게 요청이 처리되는가?
OAuth2, JWT 등으로 인증과정을 만들 때는 어떻게 처리되는가?
세션 정보를 어디에 어떻게 저장하는가? 또는 Redis에 session 캐시하기
기본적으로 등록되는 Security Filter들은 어떤 역할을 담당하는가?
인증은 그렇고 권한은 누가 처리하는가...?
기타...
이렇게 긴 호흡을 끝까지 읽어주셔서 정말 정말 감사합니다.

참고 자료

공식 아키텍처 설명 (https://spring.io/guides/topicals/spring-security-architecture)
기타 너무나 많은 블로그들...


출처: https://jeong-pro.tistory.com/205?category=921668 [기본기를 쌓는 정아마추어 코딩블로그]
```
