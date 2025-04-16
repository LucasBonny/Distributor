import { Link } from 'react-router-dom';
import { TbSquareLetterJFilled } from "react-icons/tb";
import { BiGridAlt, BiPieChartAlt2 } from "react-icons/bi";
import { IoSettingsSharp } from "react-icons/io5";
import { FaTruck, FaBoxOpen,FaBuilding, 
    FaUsers, FaHistory, FaRegCompass, FaChevronDown } from "react-icons/fa";

import { useState } from 'react';

import './index.css'

export const Sidebar = () => {
    const [category, setCategory] = useState(false);

    return (
        <aside className='close'>
            <div className="logoDetails">
                <TbSquareLetterJFilled  className="logoIcon" />
                <span className="logoName">Frozen Throat</span>
            </div>
            <ul>
                <li>
                    <Link className="link" to={`/`}>
                        <BiGridAlt size={25} />
                        <div className="linkAbout">
                            <span>Menu Incial</span>
                        </div>
                    </Link>
                </li>
                <li>
                    <Link className="link" onClick={() => setCategory(!category)}>
                        <FaBuilding size={25} />
                        <div className="linkAbout">
                            <span>Fornecedor</span>
                            <FaChevronDown className='arrow' />
                        </div>
                    </Link>
                    <ul className="subMenu">
                        <li className="linkName"><Link to={`/`}>Fornecedor</Link></li>
                        <li><Link to={`/`}>Cadastrar Fornecedor</Link></li>
                        <li><Link to={`/`}>Listar Fornecedores</Link></li>
                        <li><Link to={`/`}>Remover Fornecedor</Link></li>
                    </ul>
                </li>
                <li>
                    <Link className="link" to={`/`}>
                        <FaUsers size={25} />
                        <div className="linkAbout">
                            <span>Funcionários</span>
                            <FaChevronDown className='arrow' />
                        </div>
                    </Link>
                    <ul className="subMenu">
                        <li className="linkName"><Link to={`/`}>Funcionários</Link></li>
                        <li><Link to={`/`}>Criar Funcionário</Link></li>
                        <li><Link to={`/`}>Listar Funcionários</Link></li>
                        <li><Link to={`/`}>Suspender Funcionário</Link></li>
                    </ul>
                </li>
                <li>
                    <Link className="link" to={`/`}>
                        <FaBoxOpen size={25} />
                        <div className="linkAbout">
                            <span>Produtos</span>
                            <FaChevronDown className='arrow' />
                        </div>
                    </Link>
                    <ul className="subMenu">
                        <li className="linkName"><Link to={`/`}>Produtos</Link></li>
                        <li><Link to={`/`}>Cadastrar Produto</Link></li>
                        <li><Link to={`/`}>Listar Produtos</Link></li>
                        <li><Link to={`/`}>Ver Estoque</Link></li>
                        <li><Link to={`/`}>Remover Produto</Link></li>
                    </ul>
                </li>
                <li>
                    <Link className="link" to={`/`}>
                        <FaTruck size={25} />
                        <div className="linkAbout">
                            <span>Entregas</span>
                            <FaChevronDown className='arrow' />
                        </div>
                    </Link>
                    <ul className="subMenu">
                        <li className="linkName"><Link to={`/`}>Entregas</Link></li>
                        <li><Link to={`/`}>Do Dia</Link></li>
                        <li><Link to={`/`}>Da Semana</Link></li>
                        <li><Link to={`/`}>Do Mês</Link></li>
                        <li><Link to={`/`}>Todas</Link></li>
                    </ul>
                </li>
                <li>
                    <Link className="link" to={`/`}>
                        <BiPieChartAlt2 size={25} />
                        <div className="linkAbout">
                            <span>Relatórios</span>
                        </div>
                    </Link>
                </li>
                <li>
                    <Link className="link" to={`/`}>
                        <IoSettingsSharp size={25} />
                        <div className="linkAbout">
                            <span>Configurações</span>
                        </div>
                    </Link>
                </li>
            </ul>
        </aside>
    );
}
