const UrlParams = new URLSearchParams(window.location.search);
const pizzaId = UrlParams.get('id');
let boxShow = document.querySelector('#box_show');

axios.get(`http://localhost:8080/api/pizze/${pizzaId}`).then((response) => {
    console.log("Richiesta ok", response);
    let pizza = response.data;
    console.log(pizza);
    let listaIngredienti = pizza.ingredienti;
    let listaOfferte = pizza.offerteList;
   // console.log(ingredienti);
    boxShow.innerHTML = `
    <img alt="${pizza.nome} + '\'s pizza'" src="${pizza.foto}" class="w-100 h-100 img_detail" style="object-fit: cover">
    <div class="body_detail p-4 rounded-1">
        <div class="title_detail">
            <h2>${pizza.id} - ${pizza.nome}</h2>
        </div>
        <p class="card-text mt-4">
            <span class="d-block">Descrizione:</span> ${pizza.descrizione}
        </p>
        <p id="ingredienti" class="card-text">Ingredienti:<br> </p>

        <h6>
            <span class="d-block">Prezzo:</span> ${pizza.prezzo} €
        </h6>
        <div id="box_offerte"> 
        </div>
    </div>
    `;
    let ingredienti = document.querySelector('#ingredienti');
    listaIngredienti.forEach(ingrediente => {
        ingredienti.innerHTML += `
            <span>${ingrediente.name} </span> 
        `;
    });

    if(listaOfferte.length > 0){
        document.querySelector('#box_offerte').innerHTML = `
        <h4>Offerte:</h4>
        <ul id="offerte"> </ul>
        `;
        let offerte = document.querySelector('#offerte'); 
        listaOfferte.forEach(offerta => {
            offerte.innerHTML += `
                <li>${offerta.name} : ${offerta.startOfferDate} / ${offerta.endOfferDate}</li>
            `;
        });
    };


}).catch((error) => {
    console.error("Richiesta del dettaglio errata");
})