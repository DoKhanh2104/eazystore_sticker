import PageTitle from "./PageTitle";
import { MdWorkspacePremium } from "react-icons/md";
import { FaGem } from "react-icons/fa";
import { FaStar } from "react-icons/fa6";
import { TbCloverFilled } from "react-icons/tb";

const About = () => {
  const h3Style =
    "flex items-center gap-1 text-lg text-primary font-semibold dark:text-light mb-2";
  const pStyle = "text-gray-600 dark:text-lighter";

  return (
    <div className="max-w-[1152px] min-h-[600px] mx-auto px-6 py-8 font-primary">
      <PageTitle title={"About us"} />

      {/* Content */}
      <p className="leading-6 mb-8 text-gray-600 dark:text-lighter">
        <span className="text-lg font-semibold text-primary dark:text-light">
          Eazy sticker
        </span>{" "}
        store is an initiative by{" "}
        <span className="text-lg font-semibold text-primary dark:text-light">
          Design by Devi the dev
        </span>{" "}
        ,dedicated to offering you the most sought-after stickers and poster
      </p>

      {/* Why choose section */}
      <h2 className="leading-[32px] text-2xl font-bold text-primary dark:text-light mb-6">
        Why choose us?
      </h2>

      {/* Features */}
      <div className="space-y-8">
        {/* Feature: Premium */}
        <div>
          <h3 className={h3Style}>
            <FaGem className="text-xl pb-1" />
            Premium Quality
          </h3>
          <p className={pStyle}>
            We use high-quality materials and advanced printing techniques to
            ensure every sticker looks sharp, vibrant, and long-lasting. Our
            stickers are waterproof, fade-resistant, and made to stick with you
            wherever you go.
          </p>
        </div>

        {/* Feature: Production Innovation */}
        <div>
          <h3 className={h3Style}>
            <MdWorkspacePremium className="text-2xl pb-1" />
            Production Innovation
          </h3>
          <p className={pStyle}>
            Quality isn’t just a promise — it’s our standard. From material
            selection to final inspection, every sticker is carefully crafted to
            deliver a premium feel you can see and touch.
          </p>
        </div>

        {/* Feature: Excellent Service */}
        <div>
          <h3 className={h3Style}>
            <FaStar className="text-xl pb-1" />
            Excellent Service
          </h3>
          <p className={pStyle}>
            Your satisfaction is our priority. We’re always here to help, from
            choosing the right designs to resolving any issues quickly and
            professionally. Friendly support, fast responses, and a smooth
            shopping experience — every time.
          </p>
        </div>

        {/* Feature: Design You'll Love */}
        <div>
          <h3 className={h3Style}>
            <TbCloverFilled className="text-2xl pb-1" />
            Design Your Love
          </h3>
          <p className={pStyle}>
            We create stickers that inspire, express personality, and make
            everyday items more fun. Whether you love minimal styles, cute
            characters, or bold statements, our designs are made to match your
            vibe.
          </p>
        </div>
      </div>
    </div>
  );
};

export default About;
