import PageTitle from "./PageTitle";

const Contact = () => {
  const labelStyle =
    "block text-lg font-semibold text-primary dark:text-light mb-2";
  const textFieldStyle =
    "w-full px-4 py-2 text-base border rounded-md transition border-primary dark:border-light focus:ring focus:ring-dark dark:focus:ring-lighter focus:outline-none text-gray-800 dark:text-lighter bg-white dark:bg-gray-600 placeholder-gray-400 dark:placeholder-gray-300";

  return (
    <div className="max-w-[1152px] min-h-[652px] mx-auto px-6 py-8 font-primary bg-normalbg dark:bg-darkbg">
      {/* Page Title */}
      <PageTitle title={"Contact Us"} />

      {/* Contact Info */}
      <p className="max-w-[768px] mx-auto mt-8 text-gray-600 dark:text-lighter text-center mb-8">
        We’d love to hear from you! If you have any questions, feedback, or
        suggestions, please don’t hesitate to reach out.
      </p>

      {/* Contact form */}
      <form className="max-w-[768px] mx-auto space-y-6">
        {/* Name */}
        <div>
          <label htmlFor="name" className={labelStyle}>
            Name
          </label>
          <input
            className={textFieldStyle}
            id="name"
            name="name"
            required
            minLength={5}
            placeholder="Your Name"
            maxLength={32}
            type="text"
          />
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          {/* Email */}
          <div>
            <label htmlFor="email" className={labelStyle}>
              Email
            </label>
            <input
              className={textFieldStyle}
              id="email"
              name="email"
              required
              placeholder="Your Email"
              type="email"
            />
          </div>

          {/* Mobile */}
          <div>
            <label htmlFor="mobileNumber" className={labelStyle}>
              Mobile Number
            </label>
            <input
              className={textFieldStyle}
              id="mobileNumber"
              name="mobileNumber"
              required
              placeholder="Your Number"
              pattern="^\d{10}$"
              title="Mobile number must be exactly 10 digits"
              type="tel"
            />
          </div>
        </div>

        {/* Message */}
        <div>
          <label htmlFor="message" className={labelStyle}>
            Message
          </label>
          <textarea
            className={textFieldStyle}
            id="message"
            name="message"
            required
            minLength={5}
            rows={4}
            placeholder="Your Message"
            maxLength={100}
            type="text"
          />
        </div>
      </form>

      {/* Submit button */}
      <div className="flex justify-center items-center mt-8">
        <button
          type="submit"
          className="px-6 py-2 text-white dark:text-black text-xl rounded-md transition duration-200 bg-primary dark:bg-light hover:bg-dark dark:hover:bg-lighter hover:cursor-pointer"
        >
          Submit
        </button>
      </div>
    </div>
  );
};

export default Contact;
