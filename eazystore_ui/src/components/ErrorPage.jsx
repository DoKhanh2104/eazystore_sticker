import { useNavigate, useRouteError } from "react-router-dom";
import Footer from "./footer/Footer";
import Header from "./Header";
import PageTitle from "./PageTitle";
import errorImage from "../assets/util/error.png";

const ErrorPage = () => {
  const routeError = useRouteError();
  let errorTitle = "Oops! Something went wrong";
  let errorMessage = "An unexpected error occurred. Please try again later.";

  const navigation = useNavigate();
  const handleClick = () => {
    navigation("/home", { state: { username: "khanh" } });
  };

  if (routeError) {
    errorTitle = routeError.status;
    errorMessage = routeError.data;
  }

  return (
    <div>
      <Header />
      <main className="min-h-[540px]">
        <div className="flex flex-col justify-center items-center">
          <PageTitle title={errorTitle} />
          <p className="text-primary mb-4 dark:text-light">{errorMessage}</p>
          <img
            className="w-full max-w-[460px] mx-auto"
            src={errorImage}
            alt="errorImage"
          />
          <button
            className="py-2 px-4 border border-primary/45 rounded-xl bg-primary text-white my-6"
            onClick={handleClick}
          >
            Back to home
          </button>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default ErrorPage;
