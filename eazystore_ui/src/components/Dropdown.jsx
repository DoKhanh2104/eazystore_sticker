const DropDown = ({ label, options, selectedValue, handleSort }) => {
  return (
    <div className="flex items-center justify-end gap-2 pr-6 flex-1 font-primary">
      <label className="text-lg font-semibold text-primary dark:text-light">
        {label}
      </label>
      <select
        className="px-3 py-2 text-base border rounded-md text-gray-900 dark:text-light transition border-primary dark:border-light focus:ring focus:ring-dark dark:focus:ring-light focus:outline-none"
        value={selectedValue}
        onChange={(event) => handleSort(event.target.value)}
      >
        {options.map((optionValue, index) => (
          <option value={optionValue} key={index}>
            {optionValue}
          </option>
        ))}
      </select>
    </div>
  );
};

export default DropDown;
