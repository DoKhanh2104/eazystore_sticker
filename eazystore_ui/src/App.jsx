import "./App.css";
import Header from "./components/Header";
import Footer from "./components/footer/Footer";

import { Outlet, useNavigation } from "react-router-dom";

function App() {
  const navigation = useNavigation();

  return (
    <>
      <Header />
      {navigation.state === "loading" ? (
        <div className="flex justify-center items-center min-h-screen">
          <span className="text-2xl text-primary dark:text-light font-semibold">
            Loading...
          </span>
        </div>
      ) : (
        <Outlet />
      )}

      <Footer />
    </>
  );
}

export default App;
