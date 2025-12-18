import { Link, useRouteError } from "react-router-dom";
import Footer from "./footer/Footer";
import Header from "./Header";
import PageTitle from "./PageTitle";
import errorImage from "../assets/util/error.png";

const ErrorPage = () => {
  const routeError = useRouteError();

  return (
    <div>
      <Header />
      <main className="min-h-[540px]">
        <div className="flex flex-col justify-center items-center">
          <PageTitle title={routeError.status} />
          <p className="text-red-500 mb-4">{routeError.data}</p>
          <img
            className="w-full max-w-[460px] mx-auto"
            src={errorImage}
            alt="errorImage"
          />
          <Link
            className="py-2 px-4 border border-red-500 rounded-xl bg-red-500 text-white my-6"
            to="/"
          >
            Back to home
          </Link>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default ErrorPage;
