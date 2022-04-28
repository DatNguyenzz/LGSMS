const ModalWindow = {
    init() {
        document.body.addEventListener("click", e => {
            if (e.target.classList.contains("modal_close")) {
                this.closeModal(e.target);
            }
        });
        document.body.addEventListener("click", e => {
            if (e.target.classList.contains("modal_overlay")) {
                this.closeModal11(e.target);
            }
        });
    },

    getHtmlTemplate(modalOptions) {
        return `
                <div class="modal_overlay" id="overlay">
                <div class="modal_window">
                    <div class="modal_titlebar">
                        <span class="modal_title">${modalOptions.title}</span>
                        <button class="modal_close material-icons">&times;</button>
                        
                    </div>
                    <div class="modal_content">
                        ${modalOptions.content}
                    </div>
                </div>
                
            </div>
        `;
    },

    closeModal(closeButton) {
        const modalOverlay = closeButton.parentElement.parentElement.parentElement;

        document.body.removeChild(modalOverlay);

    },

    closeModal1(closeOverlay) {
        const modalOverlay1 = closeOverlay;

        document.body.removeChild(modalOverlay1);

    },
    openModal(modalOptions = {}){
        modalOptions = Object.assign({
            title: 'Modal title',
            content: 'Modal content'
        }, modalOptions);

        const modalTemplate = this.getHtmlTemplate(modalOptions);
        document.body.insertAdjacentHTML("afterbegin", modalTemplate);
        setTimeout(() => {
            const element = document.getElementById("overlay");
            element.remove();
        }, 2000);
    }
};

document.addEventListener("DOMContentLoaded", () => ModalWindow.init());