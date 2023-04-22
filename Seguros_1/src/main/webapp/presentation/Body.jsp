<main>
    <div class="wrapper">
        <div>
            <div><h3>Login</h3></div>
            <div><img src="image/login-icon.svg " alt="login-icon" style="height: 5em"></div>
        </div>
        <form name="form" action="presentation/login/login" method = "post">
            <div>
                <div class="input">
                    <div>
                        <span><img src="image/username-icon.svg" alt="username-icon" style="height: 1em;"></span>
                        <input  type="text" name="id" placeholder="Username" aria-label="id de usuario" class="<%=erroneo("id",errores)%>" value="<%=form.get("id")[0]%>" title="<%=title("id",errores)%>">
                    </div>
                </div>
                <div class="input">
                    <div>
                        <span><img src="image/password-icon.svg" alt="username-icon" style="height: 1em"> </span>
                        <input  type="password" name="clave" placeholder="Password" aria-label="clave de usuario" class="<%=erroneo("clave",errores)%>"  value="<%=form.get("clave")[0]%>" title="<%=title("clave",errores)%>">
                    </div>
                </div>
                <div>
                    <label><input type="checkbox" > Remember me</label>
                </div>
                <div>
                    <a href="#">forgot your password?</a>
                </div>
                <button type="submit" class="btn-login" name="login"> login </button>
            </div>
        </form>
        <div>
            <div><h3>Don't have an account?</h3></div>
            <a href="presentation/register/login">Register</a>
        </div>
        <div>or</div>
        <div>
            <img src="image/google-icon.svg" alt="google-icon">
            <div>Continue with Google</div>
        </div>
    </div>
</main>
