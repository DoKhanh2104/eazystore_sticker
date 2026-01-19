import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import ErrorPage from "./components/ErrorPage";
import About from "./components/About";
import Cart from "./components/Cart";
import Contact, { contactAction } from "./components/Contact";
import Login, { loginAction } from "./components/Login";
import Home, { productsLoader } from "./components/Home";
import ProductDetail from "./components/ProductDetail";
import { CartProvider } from "./store/cart-context";
import { AuthProvider } from "./store/auth-context";
import CheckoutForm from "./components/CheckoutForm";
import ProtectedRoute from "./components/ProtectedRoute";
import Profile, { profileAction, profileLoader } from "./components/Profile";
import Orders from "./components/Orders";
import AdminOrders from "./components/admin/AdminOrders";
import Messages from "./components/admin/Messages";
import Register, { registerAction } from "./components/Register";
import { Toaster } from "sonner";

const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<ErrorPage />}>
    {/* PUBLIC ROUTE */}
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="/home" element={<Home />} loader={productsLoader} />
    <Route path="/about" element={<About />} />
    <Route path="/contact" element={<Contact />} action={contactAction} />
    <Route path="/login" element={<Login />} action={loginAction} />
    <Route path="/cart" element={<Cart />} />
    <Route path="/register" element={<Register />} action={registerAction} />
    <Route path="/product/:productId" element={<ProductDetail />} />

    {/* PRIVATE ROUTE */}
    <Route element={<ProtectedRoute />}>
      <Route path="/checkout" element={<CheckoutForm />} />
      <Route
        path="/profile"
        element={<Profile />}
        loader={profileLoader}
        action={profileAction}
        shouldRevalidate={({ actionResult }) => {
          return !actionResult?.success;
        }}
      />
      <Route path="/orders" element={<Orders />} />
      <Route path="/admin/orders" element={<AdminOrders />} />
      <Route path="/admin/messages" element={<Messages />} />
    </Route>
  </Route>,
);

const appRouter = createBrowserRouter(routeDefinitions);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <AuthProvider>
      <CartProvider>
        <RouterProvider router={appRouter} />
      </CartProvider>
    </AuthProvider>
    <Toaster position="top-center" richColors />
  </StrictMode>,
);
