//
//  NewReceiptViewController.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 18/06/25.
//

import Foundation
import UIKit

class NewRecipeViewController: UIViewController {
    private let newRecipeView = NewRecipeView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupUI()
        self.setupActions()
    }
    
    private func setupUI() -> Void {
        self.view.backgroundColor = Colors.gray_100
        view.addSubview(newRecipeView)
        
        self.buildHierarchy()
    }
    
    private func buildHierarchy() -> Void {
        self.newRecipeView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            self.newRecipeView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor),
            self.newRecipeView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor),
            self.newRecipeView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor),
            self.newRecipeView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor),
        ])
    }
    
    private func setupActions() -> Void {
        self.newRecipeView.backButton.addTarget(self, action: #selector(backButtonTapped), for: UIControl.Event.touchUpInside)
    }
    
    @objc private func backButtonTapped() -> Void {
        self.navigationController?.popViewController(animated: true)
    }
}
