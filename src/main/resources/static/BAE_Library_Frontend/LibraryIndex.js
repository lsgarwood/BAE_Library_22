

    const searchByTitle = document.querySelector("#search-by-title");
    const searchByAuthor = document.querySelector("#search-by-author");
    const searchByGenre = document.querySelector("#search-by-genre");
    const searchById = document.querySelector("#search-by-id");
  
    const searchResultNumMessage = document.querySelector("#serach-result-num-msg");
    const donateBook = document.querySelector("#donate-book");
    const returnBook = document.querySelector("#return-book");
    const reportBook = document.querySelector("#report-book");
  

const baseURL = "http://localhost:8080";

    axios
        .get(`${baseURL}/`)
        .then(res => { // handle response with callback
            console.log(res);
            console.log("DATA: ", res.data);
        }).catch(err => console.log(err)); // handle error

    console.log("Library Initialising....");

const clearSearchesEl = document.querySelector("#getAllBooks");
const BookId = document.querySelector("#book-id");
const getAllBooks = () => {
   
    axios
        .get(`${baseURL}/books/getAll`)
        .then(res => {
            const books = res.data;
            clearSearchesEl.innerHTML = ""; // blanks an element
            books.forEach(book => renderBookCard(book, clearSearchesEl));
        }).catch(err => console.log(err));
}

const renderBookCard = (book) => {   
    const bookColumn = document.createElement('div');
    bookColumn.classList.add("col");
    
    const bookCard = document.createElement('div');
    kittenCard.classList.add("card");
    bookColumn.appendChild(bookCard);
    
    const newBook = document.createElement('div');
    newBook.classList.add("card-body");

    const bookCardBanner = document.createElement("span");
    bookCardBanner.innerText = book.available;
    bookCardBanner.classList.add("card-banner")
    newBook.appendChild(bookCardBanner);

    const bookCardImage = document.createElement("card-img");
    bookCardImage.  
    newBook.appendChild(bookCardBanner);
    
    const bookTitle = document.createElement("h5");
    bookTitle.innerText = book.title;
    bookTitle.classList.add("card-title");
    newBook.appendChild(bookTitle);
    
    const bookAuthor = document.createElement("p");
    bookAuthor.innerText = book.author;
    bookAuthor.classList.add("card-author");
    newBook.appendChild(bookAuthor);
    
    const bookGenre = document.createElement("p");
    bookGenre.innerText = book.author;
    bookGenre.classList.add("card-genre");
    newBook.appendChild(bookGenre);
    
    const bookCardId = document.createElement("p");
    bookCardId.innerText = book.id;
    bookCardId.classList.add("card-id");
    newBook.appendChild(bookCardId);
    
    const loanButton = document.createElement('loan-book');
    loanButton.innerText = "Loan";
    loanButton.classList.add("btn", "btn-primary");
    loanButton.addEventListener('click', () => updateBannerLoan(book.available));
    newBook.appendChild(loanButton);
    bookCard.appendChild(newBook);

    const reviewButton = document.createElement('review-book');
    reviewButton.innerText = "Review";
    reviewButton.classList.add("btn", "btn-secondary", "btn-sm");
    reviewButton.addEventListener('click', () => reviewBook(book.id));
   
    clearSearchesEl.appendChild(bookColumn);
}

// "/getByTitle/{title}" - search by title
function searchResultsByTitle() {

    axios
        .get(`${baseURL}/books/getByTitle/title`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getByAuthor/{author}" -search by author
function searchResultsByAuthor() {

    axios
        .get(`${baseURL}/books/getByAuthor/author`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getByGenre/{genre}" search by genre
function searchResultsByGenre() {

    axios
        .get(`${baseURL}/books/getByGenre/genre`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getById/{id}" search by id
function searchResultsById() {
    
    axios
        .get(`${baseURL}/books/getById/id`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getByAvailable/{available}" - serach by available

// "/createBook"- donate book
const createNewBook = () => {
   axios 
       .post(`${baseURL}/books/createBook`), {
            title:"",
            author: "",
            genre: "",
            id: ,
            available: ""
       }
       .then(res => showAll(res))
       .catch(err => alert(err));
}

// "/checkIn/{id}" - update by id


// "/checkOut/{id}" - update by id
const updateBannerLoan() {


  
}

// "/deleteBook/{id}" - delete